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

        switch (agency) {
            case 3:
                return "https://mr.travelbymexico.com/imgBase/2018/02/aem1-compressor.jpg";
            case 4:
                return "https://upload.wikimedia.org/wikipedia/en/1/1d/Algerian_Space_Agency.jpg";
            case 6:
                return "http://www.aprsaf.org/about/logo/APRSAF_Logo_Sub_POS_RGB.jpg";
            case 7:
                return "http://www.un-spider.org/sites/default/files/APSCO.jpg";
            case 11:
                return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQETFGLovcApSJ7neFcgFDpUDAGy7rsl5YsrT09u8plvOwaddEG&s";
            case 12:
                return "http://marcospalhares.com.br/wp-content/uploads/2014/10/imagem589-e1452006198518.jpg";
            case 36:
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/Asi_logo.svg/1200px-Asi_logo.svg.png";
            case 43:
                return "http://www.iafastro.org/wp-content/uploads/2014/04/Angkasa_518046.png";
            case 44:
                return "https://www.nasa.gov/sites/default/files/logo-thumbnail-full_1.jpg";
            case 80:
                return "https://ipolitics.ca/wp-content/uploads/2016/11/Boeing-HPad-1116.png";
            case 84:
                return "https://www.darc.de/fileadmin/filemounts/_processed_/2/5/csm_Amsat-Logo_430x260_1de0750d47.png";
            case 110:
                return "http://seekvectorlogo.com/wp-content/uploads/2018/03/trw-automotive-vector-logo-small.png";
            case 113:
                return "https://eapcsur.com/media/2017/12/cliente-invap.png";
            case 115:
                return "https://media.glassdoor.com/sqll/1777340/arianegroup-squarelogo-1524488326917.png";
            case 131:
                return "https://pbs.twimg.com/profile_images/1781619489/logo_400x400.jpg";
            case 133:
                return "https://res-2.cloudinary.com/crunchbase-production/image/upload/c_lpad,h_128,w_128,f_auto,q_auto:eco/v1461538888/ynsxrhexmyiw7ixg02jm.jpg";
            case 135:
                return "https://upload.wikimedia.org/wikipedia/en/b/b0/Rocketdyne_Division_company_logo_1959.png";
            case 139:
                return "https://upload.wikimedia.org/wikipedia/commons/7/7f/Armadillowidget.gif";
            case 178:
                return "https://static1.squarespace.com/static/5a5dbe4632601eb31977f947/5a5dbe9653450ab899649d1f/5b5071d7aa4a99a4f7309f23/1533724284910/airbus_416x416.jpg?format=500w";
            case 190:
                return "https://media.glassdoor.com/sqll/509848/antrix-squarelogo-1461675046297.png";
            case 203:
                return "https://www.indiantelevision.com/sites/default/files/styles/230x230/public/images/tv-images/2019/09/09/ses.jpg";
            case 207:
                return "http://www.arrakmia.com/wp-content/uploads/2014/04/arabsat.jpg";
            case 225:
                return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDqwTSfcUXjOwbzhpFjLR098k3-SxM_NU77URK9cmJ5CWcTsT-&s";
            case 251:
                return "https://www.albawaba.com/sites/default/files/styles/d08_traditional/public/im/pr_new/yahsat_logo_new_size.jpg?itok=bYhsLM_8";
            case 255:
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Avanti_logos_Purple.png/440px-Avanti_logos_Purple.png";
            case 271:
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Army_Ballistic_Missile_Agency_Logo.png/440px-Army_Ballistic_Missile_Agency_Logo.png";
            case 274:
                return "http://www.i-space.com.cn/statics/ispace/images/logo.png";
            case 278:
                return "https://blog.executivebiz.com/wp-content/uploads/2017/11/ICEYE-logo.png";
            case 282:
                return "https://pbs.twimg.com/profile_images/758774066094432256/eh1oe7_x_400x400.jpg";
            default:
                return null;
        }

    }
}


