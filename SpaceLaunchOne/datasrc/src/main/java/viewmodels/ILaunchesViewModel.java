package viewmodels;

import java.util.List;

import androidx.lifecycle.LiveData;
import local.Launch;

public interface ILaunchesViewModel {

    LiveData<List<Launch>> getLaunches();
}
