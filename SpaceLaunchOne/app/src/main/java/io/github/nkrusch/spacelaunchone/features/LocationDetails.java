package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.features.locations.details.LocationLaunchRecyclerView;
import io.github.nkrusch.spacelaunchone.features.locations.details.PadRecyclerView;
import viewmodels.LocationDetailsViewModel;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class LocationDetails extends AppCompatActivity {

    private final String ACTIVE_TAB = "active_tab";
    private static final String EXTRA_ID = "extra_id";
    private static final String EXTRA_NAME = "extra_name";
    private ProgressBar mProgress;
    protected ViewPager mPager;
    protected TabLayout tabLayout;
    private View mLayout;
    LocationDetailsViewModel vm;

    public static Intent getIntent(Context ctx, int id, String name) {
        Intent intent = new Intent(ctx, LocationDetails.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int locationId = getIntent().getIntExtra(EXTRA_ID, -1);
        String title = getIntent().getStringExtra(EXTRA_NAME);
        final int activeTab = (savedInstanceState != null &&
                savedInstanceState.containsKey(ACTIVE_TAB)) ?
                savedInstanceState.getInt(ACTIVE_TAB) : 0;

        setContentView(R.layout.activity_location);
        mPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabs);
        mProgress = findViewById(R.id.progress);
        mLayout = findViewById(R.id.content);

        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        vm = ViewModelProviders.of(this).get(LocationDetailsViewModel.class);

        tabLayout.addOnTabSelectedListener(tabSelectedListener(mPager));
        mPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mPager.addOnPageChangeListener(pagerChange());

        vm.loadDetails(locationId).observe(this, new Observer<local.LocationDetails>() {
            @Override
            public void onChanged(local.LocationDetails locationDetails) {
                if (locationDetails != null) {
                    if (tabLayout.getTabCount() == 0) {
                        int padCount = locationDetails.getPads().size();
                        int launchCount = locationDetails.getLaunches().size();
                        tabLayout.addTab(tabLayout.newTab().setText("Pads "+padCount));
                        tabLayout.addTab(tabLayout.newTab().setText("Launches "+launchCount));
                        //tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_history).setText("Past "+launchCount));
                        TabLayout.Tab t = tabLayout.getTabAt(activeTab);
                        if (t != null) t.select();
                    }
                    mProgress.setVisibility(GONE);
                    mLayout.setVisibility(VISIBLE);
                }
            }
        });
    }

    private ViewPager.OnPageChangeListener pagerChange() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(
                    int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab t = tabLayout.getTabAt(position);
                if (t != null) t.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    private TabLayout.OnTabSelectedListener tabSelectedListener(final ViewPager mPager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
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

    /**
     * Details tabs adapter
     */
    public class MyAdapter extends TabsAdapter {

        MyAdapter(FragmentManager fm) {
            super(3, fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return PadRecyclerView.newInstance();
                default:
                    return LocationLaunchRecyclerView.newInstance();
            }
        }
    }

}
