package io.github.nkrusch.spacelaunchone.features;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.TabbedActivity;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.features.filters.Agencies;
import io.github.nkrusch.spacelaunchone.features.filters.Locations;
import io.github.nkrusch.spacelaunchone.features.filters.Rockets;


/**
 * Filters allow setting conditions for limiting different lists of launches.
 * This activity uses tabs and sets up the tabs and viewpager
 * and controls which fragments will load in each tab.
 */
public class FilterActivity extends TabbedActivity {

    @Override
    public String getTitleText() {
        return getResources().getString(R.string.title_activity_filters);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPager.setVisibility(View.VISIBLE);
        mProgress.setVisibility(View.GONE);
    }

    /**
     * Set the number and names of tabs for this activity
     */
    @Override
    public void addToolbarTabs(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.filter_by_agency)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.filter_by_location)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.filter_by_rocket)));
    }

    /**
     * @return viewpager adapter
     */
    @Override
    public TabsAdapter getAdapter() {
        return new FilterAdapter(getSupportFragmentManager());
    }

    /**
     * add options menu which contains help button
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }

    /**
     * Handle up action click
     * if help menu button is clicked, display model dialog fragment
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.help:
                new HelpDialogFragment().show(getSupportFragmentManager(), "help");
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Filter tabs adapter controls the viewpager content
     */
    public class FilterAdapter extends TabsAdapter {

        FilterAdapter(FragmentManager fm) {
            super(3, fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Agencies.newInstance();
                case 1:
                    return Locations.newInstance();
                case 2:
                    return Rockets.newInstance();
                default:
                    return null;
            }
        }
    }

    /**
     * Show help dialog to explain how filters work
     */
    static public class HelpDialogFragment extends DialogFragment {
        @SuppressWarnings("ConstantConditions")
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.filter_instructions);
            builder.setTitle(R.string.filter_instructions_title);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            dialog.dismiss();
                        }
                    }
            );
            return builder.create();
        }
    }
}
