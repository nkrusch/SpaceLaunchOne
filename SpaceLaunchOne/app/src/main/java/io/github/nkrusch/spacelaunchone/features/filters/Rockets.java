package io.github.nkrusch.spacelaunchone.features.filters;


import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;
import local.RocketLookup;
import viewmodels.LookupRocketsViewModel;

public class Rockets extends FilterRecyclerView<RocketLookup, LookupRocketsViewModel> {

    public static Fragment newInstance() {
        return new Rockets();
    }

    @Override
    Class<LookupRocketsViewModel> getType() {
        return LookupRocketsViewModel.class;
    }

    @Override
    int columnCount() {
        return getResources().getInteger(R.integer.filter_rockets_column_count);
    }
}
