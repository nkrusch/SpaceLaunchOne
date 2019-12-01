package viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import local.AgencyDetails;
import local.AppDatabase;

/**
 * This viewmodel provides launch details data
 */
@SuppressWarnings("SpellCheckingInspection")
public class AgencyDetailsViewModel extends AndroidViewModel  {

    private LiveData<AgencyDetails> agency;
    private final AppDatabase db;

    public AgencyDetailsViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        agency = new MutableLiveData<>();
    }

    /**
     * Initialize viewModel
     */
    public LiveData<AgencyDetails> loadDetails(final int id) {
        agency = db.dao().getAgencyDetails(id);
        return agency;
    }

    /**
     * Get launchpad details
     */
    public LiveData<AgencyDetails> get() {
        return agency;
    }

}