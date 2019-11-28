package viewmodels;

import android.app.Application;

import java.util.List;
import java.util.Objects;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import local.AppDatabase;
import local.Launch;
import local.LocationDetails;

/**
 * This viewmodel provides launch details data
 */
@SuppressWarnings("SpellCheckingInspection")
public class LocationDetailsViewModel extends AndroidViewModel  {

    private LiveData<LocationDetails> location;
    private final AppDatabase db;

    public LocationDetailsViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(this.getApplication());
        location = new MutableLiveData<>();
    }

    /**
     * Initialize viewModel
     */
    public LiveData<LocationDetails> loadDetails(final int id) {
        location = db.dao().getLocationDetails(id);
        return location;
    }

    /**
     * Get launchpad details
     */
    public LiveData<LocationDetails> get() {
        return location;
    }

}