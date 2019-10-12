package io.github.nkrusch.spacelaunchone.features.launches;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.nkrusch.spacelaunchone.R;
import viewmodels.SearchLaunchesViewModel;

/**
 * This list fragment shows a list of launches matching query result
 */
public class SearchLaunches extends LaunchRecyclerView<SearchLaunchesViewModel> {

    @Override
    Class getType() {
        return SearchLaunchesViewModel.class;
    }

    @Override
    boolean showNextLaunch() {
        return false;
    }

    public static Fragment newInstance() {
        return new SearchLaunches();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mEmptyStateText.setText(R.string.no_matches);
        mEmptyStateText.setGravity(Gravity.TOP);
        return view;
    }
}
