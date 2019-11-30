package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.SyncActivity;
import io.github.nkrusch.spacelaunchone.app.SyncUtility;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import io.github.nkrusch.spacelaunchone.features.launches.FutureLaunches;
import io.github.nkrusch.spacelaunchone.features.launches.PastLaunches;

/**
 * This is the main activity of the application and features
 * next launch information and list of upcoming launches.
 * Next launch and list are independent fragments.
 * This activity manages activity toolbar and its options.
 * The ImageView grid is used by tablet devices.
 * See {@link NewMainActivity} for mobile & small tablet version that
 * repalces this activity.
 */
public class ImageListActivity extends SyncActivity {

    private final String EXTRA_LISTVIEW = "extra_list_view";
    private FrameLayout launchesContainer;
    private boolean currentLaunchState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_lists);
        launchesContainer = findViewById(R.id.launches_container);
        if (savedInstanceState != null) {
            currentLaunchState = savedInstanceState.getBoolean(EXTRA_LISTVIEW, false);
        }
        setLaunchesFragment(currentLaunchState);
        checkSyncStatus();
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
     * Create the activity options menu. Conditionally show past launches option
     * if there are any entries in the local database.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
     * Load launch list fragment
     *
     * @param showCompletedLaunches set TRUE to display past launches
     */
    private void setLaunchesFragment(boolean showCompletedLaunches) {
        Fragment f = showCompletedLaunches ?
                PastLaunches.newInstance() : FutureLaunches.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_none)
                .replace(launchesContainer.getId(), f)
                .commit();

        String currentState = getString(showCompletedLaunches ?
                R.string.title_activity_history : R.string.title_activity_main);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(currentState);
    }

    /**
     * Preserve view state
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(EXTRA_LISTVIEW, currentLaunchState);
        super.onSaveInstanceState(outState);
    }

    /**
     * Scroll to top of list
     */
    private void scrollToTop() {
        ((RecyclerView) findViewById(R.id.recyclerView)).scrollToPosition(0);
    }
}