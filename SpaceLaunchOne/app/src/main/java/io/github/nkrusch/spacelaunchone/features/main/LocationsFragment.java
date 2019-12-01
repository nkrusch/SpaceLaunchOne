package io.github.nkrusch.spacelaunchone.features.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;

public class LocationsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_locations, container, false);
        Toolbar mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.setTitle("Launch Locations");
        return view;
    }

    public static Fragment newInstance() {
        return new LocationsFragment();
    }

}
