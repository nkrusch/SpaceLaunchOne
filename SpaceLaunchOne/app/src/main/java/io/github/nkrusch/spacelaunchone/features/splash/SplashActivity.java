package io.github.nkrusch.spacelaunchone.features.splash;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import io.github.nkrusch.spacelaunchone.features.MainActivity;
import services.InitTime;

/**
 * This is application entry point activity.
 *
 * On first app launch this activity shows an animated loading screen while
 * waiting for initialization of the dataset. If the init behavior fails, this activity
 * will re-attempt to init on every app launch until successful.
 *
 * After successful init, this activity launches the main activity.
 */
public class SplashActivity extends InitActivity {

    /**
     * Check if app has ever been initialized; if yes, proceed straight
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
     * When initial data load has completed, launch the main activity
     */
    public void onReceiveHandler() {
        launchApp();
    }

    /**
     * Launch main activity
     */
    private void launchApp() {
        Class<?> mainActivityClass = MainActivity.class;
        Intent intent = new Intent(this, mainActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * Animate the splash icon
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