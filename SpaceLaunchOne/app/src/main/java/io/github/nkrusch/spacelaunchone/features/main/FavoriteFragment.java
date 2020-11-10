package io.github.nkrusch.spacelaunchone.features.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;

public class FavoriteFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        Toolbar mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.setTitle("Favorite Launches");
        return view;
    }

    public static Fragment newInstance() {
        return new FavoriteFragment();
    }

}
