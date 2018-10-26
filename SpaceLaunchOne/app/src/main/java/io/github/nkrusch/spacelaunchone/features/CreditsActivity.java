package io.github.nkrusch.spacelaunchone.features;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import io.github.nkrusch.spacelaunchone.R;

/**
 * This activity shows information about this app
 * such as image credits and version number.
 * The text content of this activity is defined in res/values
 * as a string-array. That array is laoded into a recyclerView for display.
 */
public class CreditsActivity extends AppCompatActivity {

    private final String EXTRA_RVSTATE = "recyclerview_state";
    private RecyclerView mRecyclerView;

    /**
     * On lifecycle changes, restore the previous state
     */
    private void restoreRecyclerViewState(Bundle savedInstanceState) {
        if (savedInstanceState != null && mRecyclerView != null && savedInstanceState.containsKey(EXTRA_RVSTATE))
            mRecyclerView.scrollToPosition(savedInstanceState.getInt(EXTRA_RVSTATE));
    }

    /**
     * Save recyclerView state
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        int scrollPosition = 0;
        if (mRecyclerView.getLayoutManager() != null) {
            LinearLayoutManager lm =
                    ((LinearLayoutManager) mRecyclerView.getLayoutManager());
            scrollPosition = lm.findFirstCompletelyVisibleItemPosition();
        }
        outState.putInt(EXTRA_RVSTATE, scrollPosition);
        super.onSaveInstanceState(outState);
    }

    /**
     * Read string array from resources and map it as key value pairs
     * where key becomes the label and value the text content.
     * Since text array is a simple string, split the string using a
     * known separator to separate key and value.
     * Then initialize the recyclerView and provide it the key,value pair data
     * to display
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        ActionBar ab = getSupportActionBar();
        if (ab != null) ab.setDisplayHomeAsUpEnabled(true);

        TypedArray credits = getResources().obtainTypedArray(R.array.credits_array);
        final String separator = getString(R.string.credits_array_separator);

        List<Pair<String, String>> data = new LinkedList();
        for (int n = 0; n < credits.length(); n++) {
            String[] pairs = (String.format("%s", credits.getString(n))).split(separator, 2);
            data.add(new Pair(pairs[0].trim(), pairs[1].trim()));
        }
        String version = tryGetVersion();
        if (version != null) data.add(new Pair(getString(R.string.version), version));
        credits.recycle();

        RecyclerView.Adapter mAdapter = new CreditsAdapter(data);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, lm.getOrientation());
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        restoreRecyclerViewState(savedInstanceState);
    }

    /**
     * Get version number of currently running application
     */
    private String tryGetVersion() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "-";
    }

    /**
     * Simple adapter for rendering key value pairs
     */
    public class CreditsAdapter extends RecyclerView.Adapter<CreditsAdapter.ItemViewHolder> {

        private final List<Pair<String, String>> dataSource;

        CreditsAdapter(List<Pair<String, String>> dataArgs) {
            dataSource = dataArgs;
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        @NonNull
        @Override
        public CreditsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CreditsAdapter.ItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_credit_list, parent, false));
        }

        /**
         * Bind the view data; make links clickable
         *
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(@NonNull final CreditsAdapter.ItemViewHolder holder, int position) {
            Pair<String, String> entry = dataSource.get(position);
            holder.label.setText(entry.first);
            holder.value.setText(Html.fromHtml(entry.second));
            if (entry.second.contains("href")) {
                holder.value.setMovementMethod(LinkMovementMethod.getInstance());
                holder.value.setPadding(0, 20, 0, 20);
            }
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder {

            private final TextView label;
            private final TextView value;

            ItemViewHolder(View v) {
                super(v);
                label = v.findViewById(R.id.list_label);
                value = v.findViewById(R.id.list_value);
            }
        }
    }
}
