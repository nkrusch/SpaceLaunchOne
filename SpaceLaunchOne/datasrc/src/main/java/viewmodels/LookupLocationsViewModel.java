package viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import api.AppExecutors;
import local.AppDatabase;
import local.LocationFilter;
import local.LocationLookup;

public class LookupLocationsViewModel extends AndroidViewModel implements IFilterViewModel<LocationLookup> {

    private final LiveData<List<LocationLookup>> locations;
    private final AppDatabase db;

    public LookupLocationsViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        locations = db.dao().getLocationLookup();
    }

    public LiveData<List<LocationLookup>> getAll() {
        return locations;
    }

    public void toggle(final LocationLookup l) {
        AppExecutors.getInstance().DiskIO().execute(new Runnable() {
            @Override
            public void run() {
                LocationFilter lf = new LocationFilter(l.getId());
                if (l.isFiltered()) db.dao().deleteFilters(lf);
                else db.dao().addAFilters(lf);
            }
        });
    }

    public void setAll(final boolean insert) {
        AppExecutors.getInstance().DiskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (locations.getValue() == null) return;
                LocationFilter[] data = new LocationFilter[locations.getValue().size()];
                for (int i = 0; i < locations.getValue().size(); i++)
                    data[i] = new LocationFilter(locations.getValue().get(i).getId());
                if (!insert)
                    db.dao().deleteFilters(data);
                else
                    db.dao().addAFilters(data);
            }
        });
    }
}



