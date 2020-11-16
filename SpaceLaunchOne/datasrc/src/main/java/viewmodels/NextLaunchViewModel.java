package viewmodels;

import android.app.Application;

import java.util.Date;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import local.AppDatabase;
import local.Launch;
import utilities.AppExecutors;

/**
 * This view model provides the next upcoming launch
 */
public class NextLaunchViewModel extends AndroidViewModel {

    private LiveData<Launch> launch;
    private long currentTimeMs;
    private final AppDatabase db;

    public NextLaunchViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        currentTimeMs = new Date().getTime();
        launch = db.dao().getNext(currentTimeMs);
    }

    public LiveData<Launch> getNext() {
        return launch;
    }

    public void reload() {
        AppExecutors.getInstance().DiskIO().execute(() -> {
            currentTimeMs = new Date().getTime();
            launch = db.dao().getNext(currentTimeMs);
        });
    }
}
