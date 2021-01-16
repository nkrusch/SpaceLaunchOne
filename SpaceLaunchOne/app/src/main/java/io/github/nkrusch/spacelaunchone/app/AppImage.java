package io.github.nkrusch.spacelaunchone.app;

import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static android.view.View.VISIBLE;

/**
 * Writing this wrapper class so if (and when) Picasso implementation
 * changes, it will be easy to update the syntax in one place. Do
 * not refer to picasso directly outside this class. Add new methods
 * here if use case is not handled by what is already here.
 * <p>
 * Use this class for loading images that either are hosted remotely
 * or need to be transformed, e.g. circular view.
 */
public class AppImage {

    /**
     * Load image from URL into square target
     * On error behavior: display default resource image instead
     *
     * @param imageURL      - URL o image to load
     * @param width         - image size
     * @param target        - view where to load image
     * @param errorResource - local resource that will be displayed if loading fails
     */
    public static void LoadSquareImageFromURL(
            String imageURL,
            int width,
            ImageView target,
            int errorResource) {
        Picasso.get()
                .load(Utilities.squareImage(imageURL, width))
                .into(target, loadResourceCallback(target, errorResource));
    }

    /**
     * Load image from URL into circular target
     * On error behavior: do nothing
     *
     * @param res    - local resource id to load
     * @param target - view where to load image
     */
    public static void LoadCircleImage(String res, ImageView target) {
        Picasso.get()
                .load(res)
                .noFade()
                .transform(new CircleTransform())
                .into(target);
    }

    /**
     * Load image from URL into circular target
     * On error behavior: display default resource image instead
     *
     * @param res           - local resource id
     * @param target        - view where to load image
     * @param errorResource - local resource that will be displayed if loading fails
     */
    public static void LoadCircleImage(String res, ImageView target, int errorResource) {
        Picasso.get()
                .load(res)
                .noFade()
                .transform(new CircleTransform())
                .into(target, loadResourceCallback(target, errorResource));
    }

    /**
     * Load image from URL into some target view
     * On error behavior: do nothing
     *
     * @param imageURL - URL of image to load
     * @param target   - view where to load image
     */
    public static void LoadImageFromURL(String imageURL, ImageView target) {
        Picasso.get()
                .load(imageURL)
                .into(target);
    }

    /**
     * Load image from URL into some target
     * On error behavior: display default resource image instead
     *
     * @param imageURL      - URL o image to load
     * @param target        - view where to load image
     * @param errorResource - local resource that will be displayed if loading fails
     */
    public static void LoadImageFromURL(String imageURL, ImageView target, int errorResource) {
        Picasso.get()
                .load(imageURL)
                .into(target, loadResourceCallback(target, errorResource));
    }

    /**
     * Attempt to load image into hidden view, and if successful, make that view visible.
     * View is assumed to be initially GONE.
     * On error behavior: No image will be visible to user if image load fails
     *
     * @param imageURL - URL o image to load
     * @param target   - view where to load image
     */
    public static void LoadAndDisplay(String imageURL, ImageView target, View visibleTarget) {
        Picasso.get()
                .load(imageURL)
                .into(target, new Callback() {
                    @Override
                    public void onSuccess() {
                        visibleTarget.setVisibility(VISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
    }

    /**
     * Callback that loads local image resource into target ImageView when onError occurs
     *
     * @param target        - image view where image is being loaded
     * @param errorResource - local resource id
     */
    private static Callback loadResourceCallback(ImageView target, int errorResource) {
        return new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(Exception e) {
                target.setImageResource(errorResource);
            }
        };
    }
}
