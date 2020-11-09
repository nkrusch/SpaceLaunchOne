package io.github.nkrusch.spacelaunchone.app;

import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static android.view.View.VISIBLE;

/**
 * Writing this wrapper class so if and when Picasso implementation
 * changes, it will be easy to update the syntax in one place
 */
public class AppImage {

    /**
     * Load image from URL into square target; if it display default res image instead
     * @param imageURL
     * @param width
     * @param target
     * @param errorResource
     */
    public static void LoadSquareImageFromURL(
            String imageURL,
            int width,
            ImageView target,
            int errorResource) {
        Picasso
                .get()
                .load(Utilities.squareImage(imageURL, width))
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

    /**
     * Load image from URL into circular target; if it fails do nothing
     * @param res
     * @param target
     */
    public static void LoadCircleImage(String res, ImageView target) {
        Picasso.get()
                .load(res)
                .noFade()
                .transform(new CircleTransform()).into(target);
    }

    /**
     * Load image from URL into circular target; if it display default res image instead
     * @param res
     * @param target
     * @param errorResource
     */
    public static void LoadCircleImage(String res, ImageView target, int errorResource) {
        Picasso.get()
                .load(res)
                .noFade()
                .transform(new CircleTransform()).into(target, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(Exception e) {
                target.setImageResource(errorResource);
            }
        });
    }

    /**
     * Load image from URL into some target; if it fails do nothing
     * @param imageURL
     * @param target
     */
    public static void LoadImageFromURL(
            String imageURL,
            ImageView target) {
        Picasso
                .get()
                .load(imageURL)
                .into(target);
    }

    /**
     * Load image from URL into some target; if it fails display default res image instead
     * @param imageURL
     * @param target
     * @param errorResource
     */
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

    /**
     * Attempt to load image into hidden view, and if successful, make that view visible
     * @param imageURL
     * @param target
     */
    public static void LoadAndDisplay(
            String imageURL,
            ImageView target,
            View visibleTarget) {
        Picasso
                .get()
                .load(imageURL)
                .into(target, new Callback() {
                    @Override
                    public void onSuccess() {
                        ((View)  visibleTarget).setVisibility(VISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
    }


}
