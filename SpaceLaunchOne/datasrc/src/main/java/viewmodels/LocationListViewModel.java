package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import local.AppDatabase;
import local.Location;
import local.LocationLookup;

public class LocationListViewModel extends AndroidViewModel {

    private final LiveData<List<Location>> locations;

    public LocationListViewModel(Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        locations = db.dao().locations(Integer.MAX_VALUE, 0);
    }

    public LiveData<List<Location>> getAll() {
        return locations;
    }

}



