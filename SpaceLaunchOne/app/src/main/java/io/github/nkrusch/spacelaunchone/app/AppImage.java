package io.github.nkrusch.spacelaunchone.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Writing this wrapper class so if and when Picasso implementation
 * changes, it will be easy to update the syntax in one place
 */
public class AppImage {

    public static void LoadSquareImageFromURL(
            String imageURL,
            int width,
            ImageView target,
            int errorResource) {

        Log.d("IMAGE", imageURL);
        Picasso
                .get()
                .load(Utilities.squareImage(imageURL, width))
                .into(target, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("IMAGE", e.getMessage().toString());
                        target.setImageResource(errorResource);

                    }
                });
    }

    public static void LoadImageFromURL(
            String imageURL,
            ImageView target,
            int errorResource) {
        Picasso
                .get()
                .load(imageURL)
                .into(target, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError(Exception e) {
                        target.setImageResource(errorResource);

                    }
                });
    }


}
