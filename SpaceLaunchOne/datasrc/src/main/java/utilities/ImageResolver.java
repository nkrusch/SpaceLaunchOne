package utilities;

import api.AsyncCallback;
import models.data.BuildConfig;

/**
 * This class provides image utilities for finding the best image of some resource
 */
public class ImageResolver {
    private void get(final String urlStr, final AsyncCallback<String> callback) {
        callback.onSuccess(null);
    }

    public void resolveImage(final local.Rocket rocket, final AsyncCallback<String> callback) {
        final String defaultImage = rocket.getImageURL();
        callback.onSuccess(defaultImage);
    }

    public static String resolveImage(final int agency) {
        return String.format(BuildConfig.ImageAssetPath + "agencies/%s.jpg", agency);
    }

    public static String resolveMissionImage(final String category) {
        return String.format(BuildConfig.ImageAssetPath + "missions/%s.png",
                category.toLowerCase().replaceAll("[ /]", "_"));
    }

    public static String countryFlag(final String countryAbbrev) {
        return String.format(BuildConfig.ImageAssetPath + "flags/flag_%s.webp", countryAbbrev);
    }
}


