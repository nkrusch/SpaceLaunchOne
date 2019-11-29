package viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import api.AppExecutors;
import local.Agency;
import local.AgencyFilter;
import local.Agency;
import local.AppDatabase;
import local.Launch;

public class AgencyListViewModel extends AndroidViewModel {

    private final LiveData<List<Agency>> agencies;

    public AgencyListViewModel(Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        agencies = db.dao().agencies(Integer.MAX_VALUE, 0);
    }

    public LiveData<List<Agency>> getAll() {
        return agencies;
    }

}



