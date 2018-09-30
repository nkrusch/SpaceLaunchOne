package viewmodels;

import android.arch.lifecycle.LiveData;

import java.util.List;

import local.Launch;

public interface ILaunchesViewModel {
    LiveData<List<Launch>> getLaunches();
}
