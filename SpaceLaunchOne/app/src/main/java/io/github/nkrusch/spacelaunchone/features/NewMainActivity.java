package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.InitActivity;
import io.github.nkrusch.spacelaunchone.app.SyncUtility;
import io.github.nkrusch.spacelaunchone.app.TabbedActivity;
import io.github.nkrusch.spacelaunchone.app.TabsAdapter;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import io.github.nkrusch.spacelaunchone.features.launches.FutureLaunches;
import io.github.nkrusch.spacelaunchone.features.main.AgenciesFragment;
import io.github.nkrusch.spacelaunchone.features.main.FavoriteFragment;
import io.github.nkrusch.spacelaunchone.features.main.LocationsFragment;
import io.github.nkrusch.spacelaunchone.features.main.ScheduledFragment;
import local.Launch;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class NewMainActivity extends TabbedActivity {

    private final int SCHEDULED_FRAGMENT = 0;
    private final int FAV_FRAGMENT = 1;
    private final int AGENCY_FRAGMENT = 2;
    private final int LOC_FRAGMENT = 3;
    private static final int TAB_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPager.setVisibility(VISIBLE);
        mToolbar.setVisibility(GONE);
        mProgress.setVisibility(GONE);
        tabLayout.setVisibility(GONE);
        bottomNav.setVisibility(VISIBLE);

        if (!InitActivity.isInitialized(this))
            Utilities.showSnackBar(this,
                    R.string.list_empty,
                    Snackbar.LENGTH_INDEFINITE);

        checkSyncStatus();
    }

    /**
     * Check application data sync status
     */
    private void checkSyncStatus() {
        Long lastExecTime = getDataSyncTimeStamp();

        /* if data sync has never executed, run it immediately */
        if (lastExecTime < 1) {
            if (Utilities.isNetworkAvailable((ConnectivityManager)
                    this.getSystemService(Context.CONNECTIVITY_SERVICE)))
                requestImmediateSync();
        }
        /* if running on a pre-lollipop handle sync status here */
        else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (SyncUtility.shouldRunPeriodicSyncPreLollipop(this))
                requestImmediateSync();
        }
    }

    @Override
    protected void setupBottomNav() {
        final Context ctx = this;

        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int pos = -1;
                        switch (item.getItemId()) {
                            case R.id.scheduled:
                                pos = SCHEDULED_FRAGMENT;
                                break;
                            case R.id.favorites:
                                pos = FAV_FRAGMENT;
                                break;
                            case R.id.agencies:
                                pos = AGENCY_FRAGMENT;
                                break;
                            case R.id.location:
                                pos = LOC_FRAGMENT;
                                break;
                            case R.id.settings:
                                startActivity(new Intent(ctx, SettingsActivity.class));
                                return true;
                        }
                        if (pos >= 0) mPager.setCurrentItem(pos);
                        return true;
                    }
                });
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
                case SCHEDULED_FRAGMENT:
                    return ScheduledFragment.newInstance();
                case FAV_FRAGMENT:
                    return FavoriteFragment.newInstance();
                case AGENCY_FRAGMENT:
                    return AgenciesFragment.newInstance();
                case LOC_FRAGMENT:
                    return LocationsFragment.newInstance();
                default:
                    return FutureLaunches.newInstance();
            }
        }
    }

}
