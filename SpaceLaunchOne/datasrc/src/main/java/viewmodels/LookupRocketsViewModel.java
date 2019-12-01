package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import api.AppExecutors;
import local.AppDatabase;
import local.RocketFilter;
import local.RocketLookup;

public class LookupRocketsViewModel extends AndroidViewModel implements IFilterViewModel<RocketLookup> {

    private final LiveData<List<RocketLookup>> rockets;
    private final AppDatabase db;

    public LookupRocketsViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        rockets = db.dao().getRocketLookup();
    }

    public LiveData<List<RocketLookup>> getAll() {
        return rockets;
    }

    public void toggle(final RocketLookup r) {
        AppExecutors.getInstance().DiskIO().execute(new Runnable() {
            @Override
            public void run() {
                RocketFilter rf = new RocketFilter(r.getId());
                if (r.isFiltered()) db.dao().deleteFilters(rf);
                else db.dao().addAFilters(rf);
            }
        });
    }

    public void setAll(final boolean insert) {
        AppExecutors.getInstance().DiskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (rockets.getValue() == null) return;
                RocketFilter[] data = new RocketFilter[rockets.getValue().size()];
                for (int i = 0; i < rockets.getValue().size(); i++)
                    data[i] = new RocketFilter(rockets.getValue().get(i).getId());
                if (!insert)
                    db.dao().deleteFilters(data);
                else
                    db.dao().addAFilters(data);
            }
        });
    }
}