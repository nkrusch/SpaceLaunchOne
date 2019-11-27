package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import api.AppExecutors;
import local.AppDatabase;
import local.LocationFilter;
import local.LocationLookup;

public class LocationListViewModel extends AndroidViewModel {

    private final LiveData<List<LocationLookup>> locations;

    public LocationListViewModel(Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        locations = db.dao().getLocationLookup();
    }

    public LiveData<List<LocationLookup>> getAll() {
        return locations;
    }

}



