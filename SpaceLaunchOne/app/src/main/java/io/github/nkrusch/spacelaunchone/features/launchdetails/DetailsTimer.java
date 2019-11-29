package io.github.nkrusch.spacelaunchone.features.launchdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.features.timers.TimerFragment;

public class DetailsTimer extends TimerFragment {

    public static Fragment newInstance(long launchTime) {
        DetailsTimer f = new DetailsTimer();
        Bundle args = new Bundle();
        args.putLong(EXTRA_LAUNCH_MS, launchTime);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_timer, container, false);
        initializeView(view);
        return view;
    }
}
