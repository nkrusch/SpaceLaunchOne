package io.github.nkrusch.spacelaunchone.features.launches;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;
import viewmodels.FavoriteLaunchesViewModel;

/**
 * This list fragment shows a list of upcoming launches
 * Clicking on list item launches details view of the selected launch event.
 */
public class FavoriteLaunches extends LaunchRecyclerView<FavoriteLaunchesViewModel> {

    @Override
    Class<FavoriteLaunchesViewModel> getType() {
        return FavoriteLaunchesViewModel.class;
    }

    public static Fragment newInstance() {
        return new FavoriteLaunches();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mEmptyStateText.setText(R.string.favorites_is_empty);
        return view;
    }
}
