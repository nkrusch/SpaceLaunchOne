package io.github.nkrusch.spacelaunchone.features.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;

public class AgenciesFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agencies, container, false);
        final Toolbar mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.setTitle("Launch Service Providers");
        return view;
    }

    public static Fragment newInstance() {
        return new AgenciesFragment();
    }

}
