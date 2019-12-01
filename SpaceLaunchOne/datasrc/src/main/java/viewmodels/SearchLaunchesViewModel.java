package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import api.AppExecutors;
import local.AppDatabase;
import local.Launch;

/**
 * This view model allows searching launches
 */
public class SearchLaunchesViewModel extends AndroidViewModel implements ILaunchesViewModel {

    private final MutableLiveData<List<Launch>> launches;
    private String lastQuery;
    private AppDatabase db;

    public SearchLaunchesViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        launches = new MutableLiveData<>();
    }

    @Override
    public LiveData<List<Launch>> getLaunches() {
        return launches;
    }

    public void setQuery(final String query) {
        if (query == null || query.equals(lastQuery) || query.length() < 2) return;
        lastQuery = query;
        AppExecutors.getInstance().DiskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        launches.postValue(db.dao().searchLaunches(query, 50, 0));
                    }
                }
        );
    }
}
