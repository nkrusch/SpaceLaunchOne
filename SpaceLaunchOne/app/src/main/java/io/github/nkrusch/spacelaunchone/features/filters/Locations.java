package io.github.nkrusch.spacelaunchone.features.filters;

import android.support.v4.app.Fragment;

import io.github.nkrusch.spacelaunchone.R;
import local.LocationLookup;
import viewmodels.LookupLocationsViewModel;

public class Locations extends FilterRecyclerView<LocationLookup, LookupLocationsViewModel> {

    public static Fragment newInstance() {
        return new Locations();
    }

    @Override
    Class getType() {
        return LookupLocationsViewModel.class;
    }

    @Override
    int columnCount() {
        return getResources().getInteger(R.integer.filter_locations_column_count);
    }
}
