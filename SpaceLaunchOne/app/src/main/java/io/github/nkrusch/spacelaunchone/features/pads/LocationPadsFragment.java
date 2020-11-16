package io.github.nkrusch.spacelaunchone.features.pads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;

public class LocationPadsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    public static Fragment newInstance() {
        return new LocationPadsFragment();
    }
}
