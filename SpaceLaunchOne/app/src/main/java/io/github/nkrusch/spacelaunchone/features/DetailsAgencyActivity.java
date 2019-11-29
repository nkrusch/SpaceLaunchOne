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
import io.github.nkrusch.spacelaunchone.app.TabbedActivity;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.features.agencies.AgencyRecyclerView;
import viewmodels.AgencyDetailsViewModel;

import static android.view.View.GONE;


public class DetailsAgencyActivity extends TabbedActivity {

    private static final String EXTRA_ID = "extra_id";
    private static final String EXTRA_NAME = "extra_name";
    private final int tabCount = 1;

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

        vm = ViewModelProviders.of(this).get(AgencyDetailsViewModel.class);
        vm.loadDetails(agencyId).observe(this, new Observer<local.AgencyDetails>() {
            @Override
            public void onChanged(local.AgencyDetails agencyDetails) {
                if(agencyDetails!=null){
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

    public void addToolbarTabs(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
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

    public class MyAdapter extends TabsAdapter {

        MyAdapter(FragmentManager fm) {
            super(tabCount, fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                default:
                    return AgencyRecyclerView.newInstance();
            }
        }
    }

}
