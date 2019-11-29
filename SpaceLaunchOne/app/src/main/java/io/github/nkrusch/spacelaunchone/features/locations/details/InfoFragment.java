package io.github.nkrusch.spacelaunchone.features.locations.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.features.details.SummaryItem;
import local.LocationDetails;
import viewmodels.LocationDetailsViewModel;

public class InfoFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        setupViewModel();
        return view;
    }

    public static Fragment newInstance() {
        return new InfoFragment();
    }

    protected void setupViewModel() {
        if (getActivity() != null) {
            LocationDetailsViewModel vm = ViewModelProviders.of(getActivity())
                    .get(LocationDetailsViewModel.class);
            vm.get().observe(getActivity(), new Observer<LocationDetails>() {
                @Override
                public void onChanged(local.LocationDetails locationDetails) {
                    if (locationDetails != null && locationDetails.getLaunches() != null)
                        handleChange(locationDetails);
                }
            });
        }
    }

    private void handleChange(LocationDetails details) {
    }


}
