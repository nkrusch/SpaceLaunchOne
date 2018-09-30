package io.github.nkrusch.spacelaunchone.features.next;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import io.github.nkrusch.spacelaunchone.features.DetailActivity;
import io.github.nkrusch.spacelaunchone.features.timers.TimerFragment;
import local.Launch;
import viewmodels.NextLaunchViewModel;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * This fragment gets the next upcoming launch and shows a countdown to that launch.
 * Clicking anywhere on the fragment launches details view about the next upcoming launch.
 */
public class NextLaunchFragment extends Fragment {

    private TextView mTitle;
    private TextView mName;
    private TextView mDate;
    private TextView mStatus;
    private FrameLayout mTimer;
    private ConstraintLayout mLayout;
    private NextLaunchViewModel vm;
    private boolean isRow;
    private int launchId;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next, container, false);
        mTimer = view.findViewById(R.id.timer);
        mName = view.findViewById(R.id.next_text);
        mDate = view.findViewById(R.id.next_date);
        mLayout = view.findViewById(R.id.layout_root);
        mTitle = view.findViewById(R.id.next_launch_title);
        mStatus = view.findViewById(R.id.next_status);
        isRow = getResources().getBoolean(R.bool.next_launch_row_item);

        ImageView launchImage = view.findViewById(R.id.image);
        TypedArray imgs = getResources().obtainTypedArray(R.array.next_launch_images);
        int dailyImageIndex = (Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) % imgs.length();
        launchImage.setImageResource(imgs.getResourceId(dailyImageIndex, -1));
        imgs.recycle();

        if (getActivity() != null)
            vm = ViewModelProviders.of(getActivity()).get(NextLaunchViewModel.class);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupViewModel();
    }

    @Override
    public void onResume() {
        super.onResume();
        vm.reload();
    }

    /**
     * bind view model
     */
    private void setupViewModel() {
        if (getActivity() != null) {
            vm.getNext().observe(getActivity(), new Observer<Launch>() {
                @Override
                public void onChanged(@Nullable Launch launch) {
                    PopulateViews(launch);
                }
            });
        }
    }

    /**
     * Update ui fields once launch data has loaded
     *
     * @param launch next launch summary
     */
    private void PopulateViews(final Launch launch) {
        if (launch == null) {
            if (isRow) mLayout.setVisibility(GONE);
            return;
        }
        mLayout.setVisibility(VISIBLE);
        mTitle.setVisibility(VISIBLE);
        mName.setText(launch.getName());
        mDate.setText(Utilities.fullTimeLabel(launch.getLaunchDateUTC()));
        mLayout.setOnClickListener(onClickListener(launch.getId(), launch.getName()));
        mStatus.setText(getString(R.string.bullet));
        mStatus.setTextColor(Color.parseColor(launch.getStatusColor()));
        if (launch.getId() != launchId) {
            addCountdown(launch.getLaunchDateUTC());
            launchId = launch.getId();
        }
    }

    /**
     * Handler when user clicks anywhere on this fragment
     * -> will launch details on that launch event
     */
    private View.OnClickListener onClickListener(final int id, final String name) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(DetailActivity.launchDetails(getContext(), id, name));
            }
        };
    }

    /**
     * When timer countdown ends, wait for a short while then reload the view
     */
    private void onTimerEnd() {
        Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                vm.reload();
            }
        };
        int reloadDelay = 20 * 1000;
        handler.postDelayed(run, reloadDelay);
    }

    /**
     * Add countdown fragment
     *
     * @param launchTimeUTC event UTC timestamp to count down to
     */
    private void addCountdown(final long launchTimeUTC) {
        TimerFragment f = (TimerFragment) TimerFragment.newInstance(launchTimeUTC);
        if (getContext() != null) f.setApplyShadow(Utilities.isPortrait(getContext()));

        if (getActivity() != null)
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.animator.slide_down, R.animator.slide_up)
                    .replace(mTimer.getId(), f)
                    .commit();
        f.registerOnFinishCallback(new TimerFragment.OnFinishCallback() {
            @Override
            public void OnFinish() {
                onTimerEnd();
            }
        });
    }
}
