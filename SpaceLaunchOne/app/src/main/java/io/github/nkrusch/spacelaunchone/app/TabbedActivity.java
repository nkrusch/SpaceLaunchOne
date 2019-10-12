package io.github.nkrusch.spacelaunchone.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.widget.ProgressBar;

import com.google.android.material.tabs.TabLayout;

import io.github.nkrusch.spacelaunchone.R;

/**
 * This is a base class for an activity with a tabbed layout.
 * This base class handles setting up the layout components
 * and preserving the active tab during activity lifecycle.
 */
public abstract class TabbedActivity extends AppCompatActivity {

    private final String ACTIVE_TAB = "active_tab";
    protected ProgressBar mProgress;
    protected ViewPager mPager;
    private Toolbar mToolbar;
    private TabLayout tabLayout;

    /**
     * This title is displayed above the tabs in the actionbar
     */
    protected abstract String getTitleText();

    /**
     * Using this method, implementing class will define
     * number and text labels for tabs that appear in the
     * actionbar.
     */
    protected abstract void addToolbarTabs(TabLayout tabLayout);

    /**
     * Implementing class will return an adapter that is
     * responsible for providing content to the ViewPager
     */
    protected abstract TabsAdapter getAdapter();

    /**
     * Override this function in the implementing activity to
     * perform custom actions when active tab changes
     *
     * @param position active tab index
     */
    protected void onTabChange(int position) {
    }

    /**
     * This handler is called when use swipes tabs to navigate
     * between the layout pages.
     * The default functionality is to highlight corresponding
     * tab in the action bar.
     */
    private ViewPager.OnPageChangeListener pagerChange() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(
                    int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab t = tabLayout.getTabAt(position);
                if (t != null) {
                    t.select();
                    onTabChange(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    /**
     * This handler is called when user clicks on a tab element
     * in the action bar.
     * The default functionality is to activate corresponding
     * ViewPager page e.g. clicking tab 0 activates ViewPage page 0.
     */
    private TabLayout.OnTabSelectedListener tabSelectedListener(final ViewPager mPager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
                onTabChange(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        };
    }

    /**
     * Restore active tab index, then setup layout elements,
     * i.e. toolbar, tabs ViewPager
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        int activeTab = 0;
        if (savedInstanceState != null &&
                savedInstanceState.containsKey(ACTIVE_TAB))
            activeTab = savedInstanceState.getInt(ACTIVE_TAB);

        mPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabs);
        mProgress = findViewById(R.id.progress);
        mToolbar = findViewById(R.id.toolbar);
        mPager.setOffscreenPageLimit(3);

        setupToolbar();
        setupTabLayout(activeTab);
        setupPager();
    }

    /**
     * Setup activity toolbar using the title provided by implementing class.
     * In horizontal orientation, hide the title because it wastes a lot of
     * space when vertical space is already limited.
     */
    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        boolean tablet = getResources().getBoolean(R.bool.is_large_device);

        if (getSupportActionBar() != null) {
            if (Utilities.isPortrait(this) || tablet) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(getTitleText());
            } else
                getSupportActionBar().hide();
        }
    }

    /**
     * Append tabs, reactivate latest tab (if any) and bind click handler
     */
    private void setupTabLayout(int activeTab) {
        addToolbarTabs(tabLayout);
        TabLayout.Tab t = tabLayout.getTabAt(activeTab);
        if (t != null) t.select();
        tabLayout.addOnTabSelectedListener(tabSelectedListener(mPager));
    }

    /**
     * Setup tab content
     */
    private void setupPager() {
        TabsAdapter mAdapter = getAdapter();
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(pagerChange());
    }

    /**
     * Preserve active tab index
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        int activeTab = tabLayout.getSelectedTabPosition();
        outState.putInt(ACTIVE_TAB, activeTab);
        super.onSaveInstanceState(outState);
    }
}
