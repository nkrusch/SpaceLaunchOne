package api;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import models.Agency;
import models.Launch;
import models.Rocket;

/**
 * This class provides image utilities for finding the best image of a rocket
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
                            if (imageUrl != null && imageUrl.length() > 0 && !imageUrl.contains(".svg")) {
                                callback.call(imageUrl);
                                return;
                            }
                        }
                        if (!urlStr.contains("wikipedia")) {
                            Elements metaIcon = doc.select("link[rel*='icon']");
                            if (metaIcon != null) {
                                imageUrl = metaIcon.attr("href");
                                if (!imageUrl.contains(".ico")) {
                                    if (!imageUrl.startsWith("http"))
                                        imageUrl = (urlStr + imageUrl).replaceAll("//", "/");
                                    callback.call(imageUrl);
                                    return;
                                }
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

    public void resolveImage(final Rocket rocket, final OnLoadCallback callback) {

        final String defaultImage = rocket.getImageURL();
        final String wikiUrl = rocket.getWikiURL();

        // if image is non-placeholder provided by API -> use it!
        if (!Launch.isPlaceholderImage(defaultImage) || wikiUrl == null || wikiUrl.length() == 0) {
            callback.call(defaultImage);
            return;
        }
        // if wikipedia article about rocket exists try to get image from there
        get(wikiUrl, new OnLoadCallback<String>() {
            @Override
            public void call(final String result) {
                boolean isValid = result != null && result.length() > 0;
                callback.call(isValid ? result : defaultImage);
            }

            @Override
            public void onError(Exception e) {
            }
        });
    }

    public static String resolveImage(final int agency) {
        return String.format("https://raw.githubusercontent.com/nkrusch/SpaceLaunchOne/master/docs/img/agencies/%d.jpg", agency);
    }

    public static String resolveMissionImage(final String category) {
        return String.format("https://raw.githubusercontent.com/nkrusch/SpaceLaunchOne/master/docs/img/missions/%s.png",
                category.toLowerCase().replaceAll("[ /]", "_"));
    }
}


