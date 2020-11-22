package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.TabbedActivity;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.features.launchdetails.SummaryFragment;
import io.github.nkrusch.spacelaunchone.features.map.LaunchMapFragment;
import viewmodels.LaunchDetailsViewModel;

import static android.view.View.GONE;

/**
 * Details activity shows details about rocket launch event.
 * This activity will setup a tab/viewpager layout and define
 * what fragments get loaded by the viewpager. The actual
 * contents of the viewpager is managed by fragments.
 */
public class DetailsLaunchActivity extends TabbedActivity {

    LaunchDetailsViewModel vm;
    public static final String EXTRA_WIDGET_LAUNCHER = "extra_widget_launch";
    private static final String EXTRA_LAUNCH = "extra_launch";
    private static final String EXTRA_NAME = "extra_name";
    private static final int TAB_COUNT = 2;
    private static final int MAP_TAB_INDEX = 1;
    private static final int SUMMARY_TAB_INDEX = 0;
    private AppBarLayout mAppbar;
    private boolean widgetLaunch;
    private String title;

    public static Intent launchDetails(Context ctx, String id, String name) {
        Intent intent = new Intent(ctx, DetailsLaunchActivity.class);
        intent.putExtra(EXTRA_LAUNCH, id);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }
    @Override
    protected boolean canToolbarCollapse() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String launchId = getIntent().getStringExtra(EXTRA_LAUNCH);
        widgetLaunch = getIntent().getIntExtra(EXTRA_WIDGET_LAUNCHER, -1) > 0;
        title = getIntent().getStringExtra(EXTRA_NAME);
        super.onCreate(savedInstanceState);
        mAppbar = findViewById(R.id.appbar_layout);
        ToggleFabVisibility(true);
        setupViewModel(launchId);
    }

    /**
     * Handle up action; if details was launched from a widget need to
     * create the back stack; else just finish current activity to return
     * to parent.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
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
     * Activity title to display in the toolbar
     */
    @Override
    public String getTitleText() {
        if (title != null && title.indexOf("|") > 0) {
            return title.substring(title.indexOf("|") + 1).trim();
        }
        return title;
    }

    /**
     * Initialize view model with selected launch id
     */
    private void setupViewModel(final String launchId) {
        vm = new ViewModelProvider(this).get(LaunchDetailsViewModel.class);
        vm.loadLaunch(launchId).observe(this, result -> {
            if (result != null) {
                mPager.setVisibility(View.VISIBLE);
                mProgress.setVisibility(GONE);
            }
        });
        vm.favorite().observe(this, result -> {
            if (result != null) {
                mFab.setImageResource(R.drawable.ic_star);
                mFab.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(getBaseContext(), R.color.favoriteFabBgTint)));
            } else {
                mFab.setImageResource(R.drawable.ic_star_outline);
                mFab.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(getBaseContext(),
                                R.color.favoriteFabBgTintInactive)));
            }
        });
    }

    /**
     * Setup details tabs toolbar options
     */
    public void addToolbarTabs(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_event)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_map)));
    }

    /**
     * When switching to maps fragment make sure the appbar is in collapsed mode
     * because the map buttons are positioned based on the available space when
     * appbar is in collapsed state.
     *
     * @param position active tab index
     */
    @Override
    protected void onTabChange(int position) {
        super.onTabChange(position);
        ToggleFabVisibility(position == SUMMARY_TAB_INDEX);
        if (position == MAP_TAB_INDEX) mAppbar.setExpanded(false, false);
    }

    private void ToggleFabVisibility(boolean visible) {
        if (visible) {
            mFab.setOnClickListener(view -> vm.ToggleFavorite());
            mFab.setVisibility(View.VISIBLE);
            AlphaAnimation animation1 = new AlphaAnimation(0f, 1f);
            animation1.setDuration(400);
            animation1.setStartOffset(300);
            animation1.setFillAfter(true);
            mFab.startAnimation(animation1);
        } else {
            mFab.setOnClickListener(null);
            mFab.setVisibility(GONE);
            mFab.setAnimation(null);
        }
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
    public static class MyAdapter extends TabsAdapter {

        MyAdapter(FragmentManager fm) {
            super(TAB_COUNT, fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 1) {
                return LaunchMapFragment.newInstance();
            }
            return SummaryFragment.newInstance();
        }
    }
}
