package io.github.nkrusch.spacelaunchone.features;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

import java.util.List;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.InitActivity;
import io.github.nkrusch.spacelaunchone.app.SyncActivity;
import io.github.nkrusch.spacelaunchone.app.SyncUtility;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.Launch;
import viewmodels.CompletedLaunchesViewModel;

/**
 * This is the main activity of the application and features
 * next launch information and list of upcoming launches.
 * Next launch and list are independent fragments.
 * This activity manages activity toolbar and its options.
 * This activity is used by mobile devices and small tablets.
 * See {@link ImageListActivity} for large tablet version that
 * repalces this activity.
 */
public class MainActivity extends SyncActivity {

    private final String EXTRA_APPBAR_STATE = "appbar_state_extra";
    private boolean showPastLaunchesOption = false;
    private CompletedLaunchesViewModel vm = null;
    private AppBarLayout mAppbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm = ViewModelProviders.of(this).get(CompletedLaunchesViewModel.class);
        mAppbar = findViewById(R.id.list_appbar_layout);
        if (!InitActivity.isInitialized(this))
            ((TextView) findViewById(R.id.list_empty_state_text))
                    .setText(R.string.list_empty);
        checkPastLaunchesStatus();
        checkSyncStatus();

        if (savedInstanceState != null && mAppbar != null && savedInstanceState.containsKey(EXTRA_APPBAR_STATE))
            mAppbar.setExpanded(savedInstanceState.getBoolean(EXTRA_APPBAR_STATE, true), false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPastLaunchesStatus();
    }

    @Override
    protected void onReceiveHandler() {
        checkPastLaunchesStatus();
    }

    /**
     * Check application data sync status
     */
    private void checkSyncStatus() {
        Long lastExecTime = getDataSyncTimeStamp();

        /* if data sync has never executed, run it immediately */
        if (lastExecTime < 1) {
            final ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (Utilities.isNetworkAvailable(cm)) requestImmediateSync();
        }
        /* if running on a pre-lollipop handle sync status here */
        else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (SyncUtility.shouldRunPeriodicSyncPreLollipop(this))
                requestImmediateSync();
        }
    }

    /**
     * Check if past launches data has initialized. If there are any items
     * in the local database for past launches, invalidate the options menu and
     * make the option visiible
     */
    private void checkPastLaunchesStatus() {
        vm.getLaunches().observe(this,
                new Observer<List<Launch>>() {
                    @Override
                    public void onChanged(@Nullable List<Launch> launches) {
                        boolean previous = showPastLaunchesOption;
                        showPastLaunchesOption = launches != null && launches.size() > 0;
                        if (previous != showPastLaunchesOption)
                            invalidateOptionsMenu();
                    }
                });
    }

    /**
     * Create the activity options menu. Conditionally show past launches option
     * if there are any entries in the local database.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        int PAST_OPTION_INDEX = 0;
        menu.getItem(PAST_OPTION_INDEX).setVisible(showPastLaunchesOption);
        return true;
    }

    /**
     * Handle menu opion clicks
     *
     * @param item selected item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.past) {
            startActivity(new Intent(this, HistoryActivity.class));
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return true;
        }
        if (id == R.id.settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        if (id == R.id.filters) {
            startActivity(new Intent(this, FilterActivity.class));
            return true;
        }
        if (id == R.id.top) {
            scrollToTop();
            return true;
        }
        if(id==R.id.search){
            startActivity(new Intent(this, SearchActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Scroll to top of list
     */
    private void scrollToTop() {
        mAppbar.setExpanded(true, false);
        ((RecyclerView) findViewById(R.id.recyclerView)).scrollToPosition(0);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        boolean nextLaunchIsVisible = Utilities.isVisible(mAppbar, dm.widthPixels, dm.heightPixels);
        outState.putBoolean(EXTRA_APPBAR_STATE, nextLaunchIsVisible);
        super.onSaveInstanceState(outState);
    }
}