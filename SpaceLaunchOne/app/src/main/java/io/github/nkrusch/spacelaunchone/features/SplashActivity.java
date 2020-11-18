package io.github.nkrusch.spacelaunchone.features;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.InitActivity;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import service.InitTime;

/**
 * This activity shows an animated loading screen when initializing dataset
 * on the very first app launch. On subsequent launches this
 * activity will just launch the main activity.
 */
public class SplashActivity extends InitActivity {

    /**
     * Check if app has ever been initialized; if YES, proceed straight
     * to main activity; else show splash icon and initialize app data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (InitTime.isInitDone(Utilities.pref(this))) launchApp();
        else initializeApp();
    }

    /**
     * Fetch data on first launch and wait for completion;
     * When this fetch completes, the app can launch.
     */
    private void initializeApp() {
        animateSplashIcon();
        initAppData();
    }

    /**
     * When initial data load has completed, launch the main activity.
     */
    public void onReceiveHandler() {
        launchApp();
    }

    /**
     * Launch main activity
     */
    private void launchApp() {
        Class<?> mainActivityClass = getResources().getBoolean(R.bool.is_large_device) ?
                ImageListActivity.class : MainActivity.class;
        Intent intent = new Intent(this, mainActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * Animate splash icon
     */
    @TargetApi(23)
    private void animateSplashIcon() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            LayerDrawable drawable = (LayerDrawable) getWindow().getDecorView().getBackground();
            final AnimatedVectorDrawable anim = (AnimatedVectorDrawable) drawable.getDrawable(1);
            anim.registerAnimationCallback(new Animatable2.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    anim.start();
                }
            });
            anim.start();
        }
    }
}