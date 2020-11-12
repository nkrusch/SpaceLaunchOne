package io.github.nkrusch.spacelaunchone.features.launches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.OnItemClickListener;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import io.github.nkrusch.spacelaunchone.features.DetailsLaunchActivity;
import local.Launch;
import viewmodels.ILaunchesViewModel;

/**
 * This is a base class for a fragment that contains
 * list of launches. This fragment takes care of initializing and
 * saving state of the recyclerview.
 */
abstract class LaunchRecyclerView<S extends AndroidViewModel & ILaunchesViewModel>
        extends RecyclerViewFragment {

    private LinearLayout mEmptyState;
    TextView mEmptyStateText;
    private boolean customFirstItem;

    abstract Class<S> getType();

    protected boolean showNextLaunch(){
        return false;
    }

    /**
     * This method binds viewmodel observer.
     * When observer detects a change it calls {@link LaunchRecyclerView<Launch>{@link #handleDataChange}}
     */
    protected void setupViewModel() {
        if (getActivity() != null) {
            S vm = ViewModelProviders.of(getActivity()).get(getType());
            vm.getLaunches().observe(getActivity(), new Observer<List<Launch>>() {
                @Override
                public void onChanged(@Nullable List<Launch> launches) {
                    handleDataChange(launches);
                }
            });
        }
    }

    /**
     * When user clicks on recyclerview items launch details view
     */
    private OnItemClickListener onItemClick() {
        return new OnItemClickListener() {
            @Override
            public void onItemClick(String id, String name) {
                startActivity(DetailsLaunchActivity.launchDetails(getContext(), id, name));
            }
        };
    }

    /**
     * When viewmodel state changes, update the adapter
     */
    private void handleDataChange(@Nullable List<Launch> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            ListAdapter adapter = (ListAdapter) mRecyclerView.getAdapter();
            if (customFirstItem && entries.get(0) != null)
                entries.add(0, null);
            adapter.updateData(entries);
            adapter.notifyDataSetChanged();
        } else {
            mRecyclerView.setVisibility(View.GONE);
            mEmptyState.setVisibility(View.VISIBLE);
        }
    }

    /**
     * initialize recyclerview and bind adapter; bind item click listener; restore previous recyclerview state (if any)
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        customFirstItem = getResources().getBoolean(R.bool.is_large_device) && showNextLaunch();
        int columns = getResources().getInteger(R.integer.list_column_count);

        List<Launch> data = new LinkedList<>();
        ListAdapter la = new ListAdapter(data, customFirstItem);
        la.SetOnItemClickListener(this.onItemClick());
        GridLayoutManager glm = new GridLayoutManager(getContext(), columns);

        if (customFirstItem) glm.setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return position == 0 ? 2 : 1;
                    }
                }
        );

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(la);
        mEmptyState = view.findViewById(R.id.empty_state);
        mEmptyStateText = view.findViewById(R.id.list_empty_state_text);
        restoreRecyclerViewState(savedInstanceState);
        return view;
    }
}
