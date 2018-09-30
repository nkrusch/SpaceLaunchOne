package io.github.nkrusch.spacelaunchone.features;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.TabbedActivity;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.features.details.SummaryFragment;
import io.github.nkrusch.spacelaunchone.features.map.MapFragment;
import local.LaunchDetails;
import viewmodels.LaunchDetailsViewModel;

/**
 * Details activity shows details about rocket launch event.
 * This activity will setup a tab/viewpager layout and define
 * what fragments get loaded by the viewpager. The actual
 * contents of the viewpager is managed by fragments.
 */
public class DetailActivity extends TabbedActivity {

    public static final String EXTRA_WIDGET_LAUNCHER = "extra_widget_launch";
    private static final String EXTRA_LAUNCH = "extra_launch";
    private static final String EXTRA_NAME = "extra_name";
    private static final int TAB_COUNT = 2;
    private static final int MAP_TAB_INDEX = 1;
    private AppBarLayout mAppbar;
    private boolean widgetLaunch;
    private String title;

    public static Intent launchDetails(Context ctx, int id, String name) {
        Intent intent = new Intent(ctx, DetailActivity.class);
        intent.putExtra(EXTRA_LAUNCH, id);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int launchId = getIntent().getIntExtra(EXTRA_LAUNCH, -1);
        widgetLaunch = getIntent().getIntExtra(EXTRA_WIDGET_LAUNCHER, -1) > 0;
        title = getIntent().getStringExtra(EXTRA_NAME);
        super.onCreate(savedInstanceState);
        mAppbar = findViewById(R.id.appbar_layout);
        setupViewModel(launchId);
    }

    /**
     * Handle up action; if details was launched from a widget need to
     * create the back stack; else just finish current activity to return
     * to parent.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (widgetLaunch && upIntent != null)
                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                else finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ACtivity title to display in the toolbar
     */
    @Override
    public String getTitleText() {
        return title;
    }

    /**
     * Initialize view model with selected launch id
     */
    private void setupViewModel(final int launchId) {
        LaunchDetailsViewModel vm = ViewModelProviders.of(this).get(LaunchDetailsViewModel.class);
        vm.loadLaunch(launchId).observe(this, new Observer<LaunchDetails>() {
            @Override
            public void onChanged(@Nullable LaunchDetails result) {
                Log.d("VM", "result: " + result);
                if (result != null) {
                    mPager.setVisibility(View.VISIBLE);
                    mProgress.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * Steup details tabs toolbar options
     */
    public void addToolbarTabs(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_event)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_map)));
    }

    /**
     * When switching to maps fragment make sure the appbar is in collpased mode
     * because the map buttons are positioned based on the available space when
     * appbar is in collpased state.
     *
     * @param position active tab index
     */
    @Override
    protected void onTabChange(int position) {
        super.onTabChange(position);
        if (position == MAP_TAB_INDEX) mAppbar.setExpanded(false, false);
    }

    /**
     * return reference to tabs adapter
     */
    @Override
    public TabsAdapter getAdapter() {
        return new MyAdapter(getSupportFragmentManager());
    }

    /**
     * Details tabs adapter
     */
    public class MyAdapter extends TabsAdapter {

        MyAdapter(FragmentManager fm) {
            super(TAB_COUNT, fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return SummaryFragment.newInstance();
                case 1:
                    return MapFragment.newInstance();
                default:
                    return null;
            }
        }
    }
}
