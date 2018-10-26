package io.github.nkrusch.spacelaunchone.features.launches;

import android.support.v4.app.Fragment;

import viewmodels.FutureLaunchesViewModel;

/**
 * This list fragment shows a list of upcoming launches
 * Clicking on list item launches details view of the selected launch event.
 */
public class FutureLaunches extends LaunchRecyclerView<FutureLaunchesViewModel> {

    @Override
    Class getType() {
        return FutureLaunchesViewModel.class;
    }

    @Override
    boolean showNextLaunch() {
        return true;
    }

    public static Fragment newInstance() {
        return new FutureLaunches();
    }
}
