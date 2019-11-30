package viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.content.Context;

import java.util.Date;

import api.AppExecutors;
import local.AppDatabase;
import local.FavoriteLaunch;
import local.LaunchDetails;
import service.UpdateMethods;

/**
 * This viewmodel provides launch details data
 */
@SuppressWarnings("SpellCheckingInspection")
public class LaunchDetailsViewModel extends AndroidViewModel {

    private static final int MIN_UPDATE = models.data.BuildConfig.MinCachePolicy;
    private static final int MIN_RECENT = models.data.BuildConfig.MinRecentLimit;
    private LiveData<LaunchDetails> launch;
    private LiveData<FavoriteLaunch> favState;
    private final AppDatabase db;

    public LaunchDetailsViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        launch = new MutableLiveData<>();
    }

    /**
     * Initialize launch details viewModel
     */
    public LiveData<LaunchDetails> loadLaunch(final int id) {
        launch = db.dao().getLaunchDetails(id);
        favState = db.dao().getFavorite(id);
        conditionallyUpdate(id);
        return launch;
    }

    /**
     * Get launch details
     */
    public LiveData<LaunchDetails> get() {
        return launch;
    }

    public LiveData<FavoriteLaunch> favorite() {
        return favState;
    }

    public void ToggleFavorite() {
        if (launch.getValue() == null) return;
        int id = launch.getValue().getId();
        final FavoriteLaunch fl = new FavoriteLaunch(id);
        final boolean isFavorite = favState.getValue() != null;

        AppExecutors.getInstance().DiskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        if (isFavorite) db.dao().removeFavorite(fl);
                        else db.dao().addFavorite(fl);
                    }
                }
        );
    }

    /**
     * When viewing launch details, determine if we should try to update
     * the record by re-reading it from api endpoint.
     * Conditions to check:
     * - If enough time has elapsed since last read, update record.
     * - If launch date occurs today always update because that record is likely to get udpated often
     */
    private void conditionallyUpdate(final int id) {
        AppExecutors.getInstance().DiskIO().execute(new Runnable() {
            @Override
            public void run() {
                LaunchDetails launch = db.dao().get(id);
                if (launch == null) return;
                long current = new Date().getTime();
                long launchDate = launch.getLaunchDateUTC();
                long lastModMs = launch.getLasModified() == null ? 0 : launch.getLasModified().getTime();
                boolean occursSoon = Math.abs(current - launchDate) < MIN_RECENT;
                boolean isStale = current - lastModMs > MIN_UPDATE;
                if (!(occursSoon || isStale)) return;
                final Context context = getApplication().getBaseContext();
                UpdateMethods.UpdateLaunchDetails(context, id, null);
            }
        });
    }
}