package viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

import local.AppDatabase;
import local.Launch;

/**
 * This view model provides list of future launches
 */
public class FutureLaunchesViewModel extends AndroidViewModel implements ILaunchesViewModel {

    private final LiveData<List<Launch>> launches;

    public FutureLaunchesViewModel(Application application) {
        super(application);
        Long CUTOFF = new Date().getTime();
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        int INIT_OFFSET = 0;
        launches = db.dao().loadLaunches(CUTOFF, Integer.MAX_VALUE, INIT_OFFSET);
    }

    @Override
    public LiveData<List<Launch>> getLaunches() {
        return launches;
    }
}
