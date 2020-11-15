package viewmodels;

import android.app.Application;
import android.content.Context;

import java.util.Date;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import local.AppDataMethods;
import local.AppDatabase;
import local.FavoriteLaunch;
import local.LaunchDetails;
import utilities.AppExecutors;

/**
 * This viewmodel provides launch details data
 */
@SuppressWarnings("SpellCheckingInspection")
public class LaunchDetailsViewModel extends AndroidViewModel {

    private static final int MIN_UPDATE = apimodels.data.BuildConfig.MinCachePolicy;
    private static final int MIN_RECENT = apimodels.data.BuildConfig.MinRecentLimit;
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
    public LiveData<LaunchDetails> loadLaunch(final String id) {
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
        String id = launch.getValue().getDetail().getUUID();
        final FavoriteLaunch fl = new FavoriteLaunch(id);
        final boolean isFavorite = favState.getValue() != null;

        AppExecutors.getInstance().DiskIO().execute(
                () -> {
                    if (isFavorite) db.dao().removeFavorite(fl);
                    else db.dao().addFavorite(fl);
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
    private void conditionallyUpdate(final String id) {
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
                if (false &&!(occursSoon || isStale)) return;
                final Context context = getApplication().getBaseContext();
                AppDataMethods.updateLaunchDetails(context, id, null);
            }
        });
    }
}