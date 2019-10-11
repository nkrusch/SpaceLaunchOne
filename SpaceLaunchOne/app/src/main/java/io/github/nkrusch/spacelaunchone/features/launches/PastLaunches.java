package io.github.nkrusch.spacelaunchone.features.launches;

import androidx.core.app.Fragment;

import viewmodels.CompletedLaunchesViewModel;

/**
 * This list fragment shows a list of upcoming launches
 * Clicking on list item launches details view of the selected launch event.
 */
public class PastLaunches extends LaunchRecyclerView<CompletedLaunchesViewModel> {

    @Override
    Class getType() {
        return CompletedLaunchesViewModel.class;
    }

    @Override
    boolean showNextLaunch() {
        return false;
    }

    public static Fragment newInstance() {
        return new PastLaunches();
    }
}
