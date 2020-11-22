package io.github.nkrusch.spacelaunchone.features.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import io.github.nkrusch.spacelaunchone.features.FilterActivity;
import io.github.nkrusch.spacelaunchone.features.HistoryActivity;
import io.github.nkrusch.spacelaunchone.features.SearchActivity;

public class ScheduledFragment extends Fragment {

    private final String EXTRA_APPBAR_STATE = "appbar_state_extra";
    private AppBarLayout mAppbar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_launches, container, false);

        mAppbar = view.findViewById(R.id.list_appbar_layout);

        Toolbar mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setTitle("Future Launches");

        mToolbar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.past) {
                startActivity(new Intent(getContext(), HistoryActivity.class));
                return true;
            }
            if (id == R.id.filters) {
                startActivity(new Intent(getContext(), FilterActivity.class));
                return true;
            }
            if (id == R.id.search) {
                startActivity(new Intent(getContext(), SearchActivity.class));
                return true;
            }
            return false;
        });


        if (savedInstanceState != null && mAppbar != null && savedInstanceState.containsKey(EXTRA_APPBAR_STATE))
            mAppbar.setExpanded(savedInstanceState.getBoolean(EXTRA_APPBAR_STATE, true), false);

        return view;
    }

    public static Fragment newInstance() {
        return new ScheduledFragment();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        boolean nextLaunchIsVisible = Utilities.isVisible(mAppbar, dm.widthPixels, dm.heightPixels);
        outState.putBoolean(EXTRA_APPBAR_STATE, nextLaunchIsVisible);
        super.onSaveInstanceState(outState);
    }

}
