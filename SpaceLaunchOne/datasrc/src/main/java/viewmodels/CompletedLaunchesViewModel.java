package viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

import local.AppDatabase;
import local.Launch;

/**
 * This view model provides a list of completed launches
 */
public class CompletedLaunchesViewModel extends AndroidViewModel implements ILaunchesViewModel {

    private final LiveData<List<Launch>> launches;

    public CompletedLaunchesViewModel(Application application) {
        super(application);
        int INIT_OFFSET = 0;
        long CUTOFF = new Date().getTime();
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        launches = db.dao().pastLaunches(CUTOFF, Integer.MAX_VALUE, INIT_OFFSET);
    }

    @Override
    public LiveData<List<Launch>> getLaunches() {
        return launches;
    }
}
