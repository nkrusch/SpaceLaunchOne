package io.github.nkrusch.spacelaunchone.features.timers;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;

/**
 * This fragment shows a countdown timer to some event
 * To start timer, provide launchTime as UTC time in the Fragment constructor.
 * Parent of this fragment may also add listener to know when countdown finishes
 * using {@link TimerFragment#registerOnFinishCallback(OnFinishCallback)}
 */
public class TimerFragment extends Fragment {

    protected static final String EXTRA_LAUNCH_MS = "ms_until_launch";

    private TextView mDays;
    private TextView mHours;
    private TextView mMinutes;
    private TextView mSeconds;
    private TextView mBlastoff;
    private Group mCountdownGroup;
    private long launchTime;
    private CountDownTimer timer;
    private OnFinishCallback listener;
    private boolean useShadow;

    public interface OnFinishCallback {
        void OnFinish();
    }

    public static Fragment newInstance(long launchTime) {
        TimerFragment f = new TimerFragment();
        Bundle args = new Bundle();
        args.putLong(EXTRA_LAUNCH_MS, launchTime);
        f.setArguments(args);
        return f;
    }

    /**
     * Add callback function that will run when timer finishes
     */
    public void registerOnFinishCallback(OnFinishCallback cb) {
        listener = cb;
    }

    /**
     * Apply drop shadow to timer text fields; set this property before committing the fragment.
     *
     * @param value - set true to enable shadow
     */
    public void setApplyShadow(boolean value) {
        useShadow = value;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null)
            launchTime = bundle.getLong(EXTRA_LAUNCH_MS, 0);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        initializeView(view);
        return view;
    }

    protected void initializeView(View view) {
        mDays = view.findViewById(R.id.days);
        mHours = view.findViewById(R.id.hours);
        mMinutes = view.findViewById(R.id.mins);
        mSeconds = view.findViewById(R.id.secs);
        mCountdownGroup = view.findViewById(R.id.countdown_group);
        mBlastoff = view.findViewById(R.id.blastoff);
        if (useShadow) applyShadow(view.findViewById(R.id.layout_root));
    }

    /**
     * Start countdown clock
     */
    private void startCountdown() {
        if (timer != null) timer.cancel();
        timer = new CountDownTimer(launchTime, 100) {
            int days = -1, hours = -1, mins = -1, secs = -1;

            public void onTick(long millisUntilFinished) {
                int[] all = Utilities.fullTimeDiff(launchTime);
                boolean isFinished = all[0] + all[1] + all[2] + all[3] == 0;
                if (isFinished) {
                    onFinish();
                } else {
                    days = updateUi(mDays, days, all[0]);
                    hours = updateUi(mHours, hours, all[1]);
                    mins = updateUi(mMinutes, mins, all[2]);
                    secs = updateUi(mSeconds, secs, all[3]);
                }
            }

            private int updateUi(TextView tv, int previousValue, int nextValue) {
                if (previousValue != nextValue)
                    tv.setText(String.format(Locale.getDefault(), "%02d", nextValue));
                return nextValue;
            }

            public void onFinish() {
                this.cancel();
                if (listener != null) listener.OnFinish();
                mCountdownGroup.setVisibility(View.GONE);
                mBlastoff.setVisibility(View.VISIBLE);

                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(150);
                anim.setStartOffset(0);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(4);
                mBlastoff.startAnimation(anim);

            }
        };
        timer.start();
    }

    /**
     * Add text shadow to widget textViews
     * This helps when timer is rendered on top of image background
     */
    private void applyShadow(View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    applyShadow(child);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setShadowLayer(3, 1, 1,
                        getResources().getColor(R.color.text_shadow_color));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        startCountdown();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (timer != null) timer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) timer.cancel();
    }

}