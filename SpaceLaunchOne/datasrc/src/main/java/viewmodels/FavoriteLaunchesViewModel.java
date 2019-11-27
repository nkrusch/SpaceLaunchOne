package viewmodels;

import android.app.Application;

import java.util.Date;
import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import local.AppDatabase;
import local.Launch;

/**
 * This view model provides a list of completed launches
 */
public class FavoriteLaunchesViewModel extends AndroidViewModel implements ILaunchesViewModel {

    private final LiveData<List<Launch>> launches;

    public FavoriteLaunchesViewModel(Application application) {
        super(application);
        int INIT_OFFSET = 0;
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        launches = db.dao().favoriteLaunches(Integer.MAX_VALUE, INIT_OFFSET);
    }

    @Override
    public LiveData<List<Launch>> getLaunches() {
        return launches;
    }
}
