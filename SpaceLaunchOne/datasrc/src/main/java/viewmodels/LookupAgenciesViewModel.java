package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import local.AgencyFilter;
import local.AgencyLookup;
import local.AppDatabase;
import utilities.AppExecutors;

public class LookupAgenciesViewModel extends AndroidViewModel implements IFilterViewModel<AgencyLookup> {

    private final LiveData<List<AgencyLookup>> agencies;
    private final AppDatabase db;

    public LookupAgenciesViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        agencies = db.dao().getAgencyLookup();
    }

    public LiveData<List<AgencyLookup>> getAll() {
        return agencies;
    }

    public void toggle(final AgencyLookup a) {
        AppExecutors.getInstance().DiskIO().execute(new Runnable() {
            @Override
            public void run() {
                AgencyFilter af = new AgencyFilter(a.getId());
                if (a.isFiltered()) db.dao().deleteFilters(af);
                else db.dao().addAFilters(af);
            }
        });
    }

    public void setAll(final boolean insert) {
        AppExecutors.getInstance().DiskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (agencies.getValue() == null) return;
                AgencyFilter[] data = new AgencyFilter[agencies.getValue().size()];
                for (int i = 0; i < agencies.getValue().size(); i++)
                    data[i] = new AgencyFilter(agencies.getValue().get(i).getId());
                if (!insert)
                    db.dao().deleteFilters(data);
                else
                    db.dao().addAFilters(data);
            }
        });
    }
}



