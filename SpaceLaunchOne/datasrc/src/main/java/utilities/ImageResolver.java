package utilities;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import api.OnLoadCallback;
import models.data.BuildConfig;

/**
 * This class provides image utilities for finding the best image of some resource
 */
public class ImageResolver {

    private void get(final String urlStr, final OnLoadCallback callback) {
        AppExecutors.getInstance().networkIO().execute(new Runnable() {
            @Override
            public void run() {
                String imageUrl;
                try {
                    Connection con = Jsoup.connect(urlStr);
                    Document doc = con.get();
                    if (doc != null) {
                        Elements metaOgImage = doc.select("meta[property=og:image]");
                        if (metaOgImage != null) {
                            imageUrl = metaOgImage.attr("content");
                            if (imageUrl != null && imageUrl.length() > 0 && !imageUrl.contains(".svg") &&
                                    !imageUrl.contains("Japanese_sounding_rockets_shapes-01.jpg")) {
                                callback.call(imageUrl);
                                return;
                            }
                        }
                        Elements metaIcon = doc.select("#content .image img[src]");
                        if (metaIcon != null) {
                            imageUrl = metaIcon.attr("src");
                            if (imageUrl != null && !imageUrl.contains(".svg")) {
                                callback.call(imageUrl);
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callback.call(null);
            }
        });
    }

    public void resolveImage(final local.Rocket rocket, final OnLoadCallback callback) {

        final String defaultImage = rocket.getImageURL();
        final String wikiUrl = rocket.getWikiURL();

        // if image is non-placeholder provided by API -> use it!
        if ((defaultImage.startsWith("http")) || wikiUrl == null || wikiUrl.length() == 0) {
            callback.call(defaultImage);
            return;
        }

        // if wikipedia article about rocket exists try to get image from there
        get(wikiUrl, new OnLoadCallback<String>() {
            @Override
            public void call(final String result) {
                boolean isValid = result != null && result.length() > 0 && result.startsWith("http");
                callback.call(isValid ? result : null);
            }

            @Override
            public void onError(Exception e) {
            }
        });
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


