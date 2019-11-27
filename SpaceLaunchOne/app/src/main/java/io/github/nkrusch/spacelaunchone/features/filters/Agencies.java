package io.github.nkrusch.spacelaunchone.features.filters;


import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;
import local.AgencyLookup;
import viewmodels.LookupAgenciesViewModel;

public class Agencies extends FilterRecyclerView<AgencyLookup, LookupAgenciesViewModel> {

    public static Fragment newInstance() {
        return new Agencies();
    }

    @Override
    Class<LookupAgenciesViewModel> getType() {
        return LookupAgenciesViewModel.class;
    }

    @Override
    int columnCount() {
        return getResources().getInteger(R.integer.filter_agencies_column_count);
    }
}
