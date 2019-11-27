package viewmodels;

import androidx.lifecycle.LiveData;

import java.util.List;

import local.Launch;

public interface ILaunchesViewModel {

    LiveData<List<Launch>> getLaunches();
}
