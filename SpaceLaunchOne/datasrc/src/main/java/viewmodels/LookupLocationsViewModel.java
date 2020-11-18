package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import local.AppDatabase;
import local.IFilter;
import local.LocationFilter;
import local.LocationLookup;
import utilities.AppExecutors;

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

    public void toggle(final IFilter l) {
        AppExecutors.getInstance().DiskIO().execute(() -> {
            LocationFilter lf = new LocationFilter(l.getId());
            if (l.isFiltered()) db.dao().deleteFilters(lf);
            else db.dao().addAFilters(lf);
        });
    }

    public void setAll(final boolean insert) {
        AppExecutors.getInstance().DiskIO().execute(() -> {
            if (locations.getValue() == null) return;
            LocationFilter[] data = new LocationFilter[locations.getValue().size()];
            for (int i = 0; i < locations.getValue().size(); i++)
                data[i] = new LocationFilter(locations.getValue().get(i).getId());
            if (!insert)
                db.dao().deleteFilters(data);
            else
                db.dao().addAFilters(data);
        });
    }
}



