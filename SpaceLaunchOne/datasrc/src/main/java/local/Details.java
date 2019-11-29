package local;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import java.util.Date;

import models.Agency;
import models.Location;
import models.Pad;
import models.Rocket;



@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "details", indices = {
        @Index(value = {"rocketId", "rocketName"}),
        @Index(value = {"agencyId", "agencyName"}),
        @Index(value = {"locationId"}),
        @Index(value = {"padId", "padName"})})
public class Details {

    @NonNull
    @PrimaryKey()
    private int uid;
    private String net;
    private String hashtag;
    private String changed;
    private String wikiURL;
    private String[] vidURLs;
    private String[] infoURLs;
    private Date lastModified;

    private int agencyId;
    private String agencyName;
    private String agencyCountryCode;
    private String agencyAbbrev;
    private String agencyWikiURL;
    private String agencyImage;
    private String[] agencyInfoURLs;

    private int rocketId;
    private String rocketName;
    private String rocketFamilyName;
    private String rocketConfiguration;
    private String rocketWikiURL;
    private String[] rocketInfoURLs;

    private int locationId;
    private String locationCountryCode;
    private String locationWikiURL;
    private String[] locationURLs;

    private int padId;
    private String padName;
    private Double latitude;
    private Double longitude;
    private String padWikiURL;
    private String[] padInfoURLs;

    public Details() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyCountryCode() {
        return agencyCountryCode;
    }

    public void setAgencyCountryCode(String agencyCountryCode) {
        this.agencyCountryCode = agencyCountryCode;
    }

    public String getAgencyAbbrev() {
        return agencyAbbrev;
    }

    public void setAgencyAbbrev(String agencyAbbrev) {
        this.agencyAbbrev = agencyAbbrev;
    }

    public String getAgencyWikiURL() {
        return agencyWikiURL;
    }

    public void setAgencyWikiURL(String agencyWikiURL) {
        this.agencyWikiURL = agencyWikiURL;
    }

    public String[] getAgencyInfoURLs() {
        return agencyInfoURLs;
    }

    public void setAgencyInfoURLs(String[] agencyInfoURLs) {
        this.agencyInfoURLs = agencyInfoURLs;
    }

    public int getRocketId() {
        return rocketId;
    }

    public void setRocketId(int rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketFamilyName() {
        return rocketFamilyName;
    }

    public void setRocketFamilyName(String rocketFamilyName) {
        this.rocketFamilyName = rocketFamilyName;
    }

    public String getRocketConfiguration() {
        return rocketConfiguration;
    }

    public void setRocketConfiguration(String rocketConfiguration) {
        this.rocketConfiguration = rocketConfiguration;
    }

    public String getRocketWikiURL() {
        return rocketWikiURL;
    }

    public void setRocketWikiURL(String rocketWikiURL) {
        this.rocketWikiURL = rocketWikiURL;
    }

    public String[] getRocketInfoURLs() {
        return rocketInfoURLs;
    }

    public void setRocketInfoURLs(String[] rocketInfoURLs) {
        this.rocketInfoURLs = rocketInfoURLs;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationCountryCode() {
        return locationCountryCode;
    }

    public void setLocationCountryCode(String locationCountryCode) {
        this.locationCountryCode = locationCountryCode;
    }

    public String getLocationWikiURL() {
        return locationWikiURL;
    }

    public void setLocationWikiURL(String locationWikiURL) {
        this.locationWikiURL = locationWikiURL;
    }

    public String[] getLocationURLs() {
        return locationURLs;
    }

    public void setLocationURLs(String[] locationURLs) {
        this.locationURLs = locationURLs;
    }

    public int getPadId() {
        return padId;
    }

    public void setPadId(int padId) {
        this.padId = padId;
    }

    public String getPadName() {
        return padName;
    }

    public void setPadName(String padName) {
        this.padName = padName;
    }

    public String getPadWikiURL() {
        return padWikiURL;
    }

    public void setPadWikiURL(String padWikiURL) {
        this.padWikiURL = padWikiURL;
    }

    public String[] getPadInfoURLs() {
        return padInfoURLs;
    }

    public void setPadInfoURLs(String[] padInfoURLs) {
        this.padInfoURLs = padInfoURLs;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String[] getVidURLs() {
        return vidURLs;
    }

    public void setVidURLs(String[] vidURLs) {
        this.vidURLs = vidURLs;
    }

    public String[] getInfoURLs() {
        return infoURLs;
    }

    public void setInfoURLs(String[] infoURLs) {
        this.infoURLs = infoURLs;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getAgencyImage() {
        return agencyImage;
    }

    public void setAgencyImage(String agencyImage) {
        this.agencyImage = agencyImage;
    }

    @Ignore
    public static Details Map(models.Launch launch) {
        Details r = new Details();
        Location l = launch.getLocation();
        Rocket t = launch.getRocket();
        Agency a = launch.getLsp();

        r.setUid(launch.getId());
        r.setWikiURL(launch.getWikiURL());
        r.setHashtag(launch.getHashtag());
        r.setChanged(launch.getChanged());
        r.setNet(launch.getNet());
        r.setVidURLs(launch.getVidURLs());
        r.setInfoURLs(launch.getInfoURLs());

        if (l != null) {
            r.setLocationId(l.getId());
            r.setLocationCountryCode(l.getCountryCode());
            r.setLocationWikiURL(l.getWikiURL());
            r.setLocationURLs(l.getInfoURLs());

            Pad p = l.getPad();
            if (p != null) {
                r.setPadId(p.getId());
                r.setPadName(p.getName());
                r.setPadWikiURL(p.getWikiURL());
                r.setPadInfoURLs(p.getInfoURLs());
                r.setLatitude(p.getLatitude());
                r.setLongitude(p.getLongitude());
            }
        }
        if (a != null) {
            r.setAgencyId(a.getId());
            r.setAgencyName(a.getName());
            r.setAgencyCountryCode(a.getCountryCode());
            r.setAgencyAbbrev(a.getAbbrev());
            r.setAgencyWikiURL(a.getWikiURL());
            r.setAgencyInfoURLs(a.getInfoURLs());
            r.setAgencyImage(a.getImage());
        }
        if (t != null) {
            r.setRocketId(t.getId());
            r.setRocketName(t.getName());
            r.setRocketFamilyName(t.getFamilyName());
            r.setRocketConfiguration(t.getConfiguration());
            r.setRocketWikiURL(t.getWikiURL());
            r.setRocketInfoURLs(t.getInfoURLs());
        }

        if (l != null && a != null && t != null && l.getId() > 0 && a.getId() > 0 && t.getId() > 0)
            r.setLastModified(new Date());

        return r;
    }

    @Ignore
    @Override
    public String toString() {
        return "id:" + getUid() + "\n" +
                "padId:" + getPadId() + "\n" +
                "locationId:" + getLocationId() + "\n" +
                "rocketId:" + getRocketId() + "\n" +
                "agencyId:" + getAgencyId() + "\n" +
                "wikiURL:" + getWikiURL() + "\n" +
                "hashtag:" + getHashtag() + "\n" +
                "changed:" + getChanged() + "\n" +
                "net:" + getNet() + "\n" +
                "agencyName:" + getAgencyName() + "\n" +
                "agencyCountryCode:" + getAgencyCountryCode() + "\n" +
                "agencyAbbrev:" + getAgencyAbbrev() + "\n" +
                "agencyWikiURL:" + getAgencyWikiURL() + "\n" +
                "rocketName:" + getRocketName() + "\n" +
                "rocketFamilyName:" + getRocketFamilyName() + "\n" +
                "rocketConfiguration:" + getRocketConfiguration() + "\n" +
                "rocketWikiURL:" + getRocketWikiURL() + "\n" +
                "locationCountryCode:" + getLocationCountryCode() + "\n" +
                "locationWikiURL:" + getLocationWikiURL() + "\n" +
                "padName:" + getPadName() + "\n" +
                "padWikiURL:" + getPadWikiURL() + "\n" +
                "latitude:" + getLatitude() + "\n" +
                "longitude:" + getLongitude() + "\n" +
                "last modiefied: " + getLastModified();
    }
}