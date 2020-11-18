package io.github.nkrusch.spacelaunchone.features.launches;


import androidx.fragment.app.Fragment;
import viewmodels.CompletedLaunchesViewModel;

/**
 * This list fragment shows a list of upcoming launches
 * Clicking on list item launches details view of the selected launch event.
 */
public class PastLaunches extends LaunchRecyclerView<CompletedLaunchesViewModel> {

    @Override
    Class<CompletedLaunchesViewModel> getType() {
        return CompletedLaunchesViewModel.class;
    }

    public static Fragment newInstance() {
        return new PastLaunches();
    }
}
