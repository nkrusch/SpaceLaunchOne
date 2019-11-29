package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.TabbedActivity;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.features.pads.LocationPadsFragment;
import io.github.nkrusch.spacelaunchone.features.agencies.LocationAgencyRecyclerView;
import io.github.nkrusch.spacelaunchone.features.launches.LocationLaunchRecyclerView;
import viewmodels.LocationDetailsViewModel;

import static android.view.View.GONE;


public class DetailsLocationActivity extends TabbedActivity {

    private static final String EXTRA_ID = "extra_id";
    private static final String EXTRA_NAME = "extra_name";
    private final int tabCount = 3;
    private final int PAD_INDEX = 0;
    private final int LAUNCH_INDEX = 1;
    private final int AGENCY_INDEX = 2;

    LocationDetailsViewModel vm;
    private String title;

    public static Intent getIntent(Context ctx, int id, String name) {
        Intent intent = new Intent(ctx, DetailsLocationActivity.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int locationId = getIntent().getIntExtra(EXTRA_ID, -1);
        title = getIntent().getStringExtra(EXTRA_NAME);
        super.onCreate(savedInstanceState);

        vm = ViewModelProviders.of(this).get(LocationDetailsViewModel.class);
        vm.loadDetails(locationId).observe(this, new Observer<local.LocationDetails>() {
            @Override
            public void onChanged(local.LocationDetails locationDetails) {
                if (locationDetails != null) {
                    tabLayout.getTabAt(PAD_INDEX).setText(getResources().getQuantityString(R.plurals.tab_pads,
                            locationDetails.getPads().size(), locationDetails.getPads().size()));
                    tabLayout.getTabAt(LAUNCH_INDEX).setText(getResources().getQuantityString(R.plurals.tab_launches,
                            locationDetails.getPads().size(), locationDetails.getLaunches().size()));
                    tabLayout.getTabAt(AGENCY_INDEX).setText(getResources().getQuantityString(R.plurals.tab_agencies,
                            locationDetails.getPads().size(), locationDetails.getAgencies().size()));
                    mPager.setVisibility(View.VISIBLE);
                    mProgress.setVisibility(GONE);
                }
            }
        });
    }

    @Override
    public String getTitleText() {
        return title;
    }

    @Override
    protected TabsAdapter getAdapter() {
        return new MyAdapter(getSupportFragmentManager());
    }

    /**
     * Setup details tabs toolbar options
     */
    public void addToolbarTabs(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText(getResources()
                .getQuantityString(R.plurals.tab_pads, 0, 0)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources()
                .getQuantityString(R.plurals.tab_launches, 0, 0)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources()
                .getQuantityString(R.plurals.tab_agencies, 0, 0)));
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
     * Details tabs adapter
     */
    public class MyAdapter extends TabsAdapter {

        MyAdapter(FragmentManager fm) {
            super(tabCount, fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case LAUNCH_INDEX:
                    return LocationLaunchRecyclerView.newInstance();
                case AGENCY_INDEX:
                    return LocationAgencyRecyclerView.newInstance();
                default:
                    return LocationPadsFragment.newInstance();
            }
        }
    }

}
