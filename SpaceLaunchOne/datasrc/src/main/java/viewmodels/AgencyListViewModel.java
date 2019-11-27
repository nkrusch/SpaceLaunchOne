package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import api.AppExecutors;
import local.AgencyFilter;
import local.AgencyLookup;
import local.AppDatabase;
import local.Launch;

public class AgencyListViewModel extends AndroidViewModel {

    private final LiveData<List<AgencyLookup>> agencies;

    public AgencyListViewModel(Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        agencies = db.dao().getAgencyLookup();
    }

    public LiveData<List<AgencyLookup>> getAll() {
        return agencies;
    }

}



