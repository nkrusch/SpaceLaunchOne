package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.TabbedActivity;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.features.launches.AgencyLaunchRecyclerView;
import io.github.nkrusch.spacelaunchone.features.missions.MissionsRecyclerView;
import viewmodels.AgencyDetailsViewModel;

import static android.view.View.GONE;


public class DetailsAgencyActivity extends TabbedActivity {

    private static final String EXTRA_ID = "extra_id";
    private static final String EXTRA_NAME = "extra_name";
    private final int tabCount = 2;
    private final int LAUNCH_INDEX = 1;
    private final int MISSIONS_INDEX = 0;

    AgencyDetailsViewModel vm;
    private String title;

    public static Intent getIntent(Context ctx, int id, String name) {
        Intent intent = new Intent(ctx, DetailsAgencyActivity.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int agencyId = getIntent().getIntExtra(EXTRA_ID, -1);
        title = getIntent().getStringExtra(EXTRA_NAME);
        super.onCreate(savedInstanceState);

        vm = new ViewModelProvider(this).get(AgencyDetailsViewModel.class);
        vm.loadDetails(agencyId).observe(this, agencyDetails -> {
            if (agencyDetails != null) {
                Objects.requireNonNull(tabLayout.getTabAt(LAUNCH_INDEX)).setText(
                        getResources().getQuantityString(R.plurals.tab_launches,
                                agencyDetails.getLaunches().size(), agencyDetails.getLaunches().size()));
                Objects.requireNonNull(tabLayout.getTabAt(MISSIONS_INDEX)).setText(
                        getResources().getQuantityString(R.plurals.tab_missions,
                                agencyDetails.getMissions().size(), agencyDetails.getMissions().size()));
                mPager.setVisibility(View.VISIBLE);
                mProgress.setVisibility(GONE);
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

    public void addToolbarTabs(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText(getResources()
                .getQuantityString(R.plurals.tab_launches, 0, 0)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources()
                .getQuantityString(R.plurals.tab_missions, 0, 0)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends TabsAdapter {

        MyAdapter(FragmentManager fm) {
            super(tabCount, fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == MISSIONS_INDEX) {
                return MissionsRecyclerView.newInstance();
            }
            return AgencyLaunchRecyclerView.newInstance();
        }
    }

}
