package local;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import ll2.models.LaunchDetailed;
import ll2.models.LauncherConfigDetail;
import ll2.models.LauncherConfigList;
import ll2.models.RocketSerializerCommon;


@Entity(tableName = "rockets")
public class Rocket {

    @NonNull
    @PrimaryKey()
    private int rid;
    private String name;
    private String familyName;
    private String configuration;
    private String wikiURL;
    private String[] infoURLs;
    private String imageURL;
    private Date lastModified;

    public Rocket() {
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public String[] getInfoURLs() {
        return infoURLs;
    }

    public void setInfoURLs(String[] infoURLs) {
        this.infoURLs = infoURLs;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    // used internally while resolving images
    @Ignore
    private List<String> launchIds = new LinkedList<>();

    @Ignore
    public List<String> getLaunchIds() {
        return launchIds;
    }

    @Ignore
    public void addLaunchId(String launchId) {
        this.launchIds.add(launchId);
    }

    @Ignore
    public static Rocket Map(RocketSerializerCommon rocket) {
        Rocket r = new Rocket();
        LauncherConfigList c = rocket.getConfiguration();
        r.setRid(c.getId());
        r.setName(c.getName());
        r.setFamilyName(c.getFamily());
        r.setConfiguration(c.getFullName());
        r.setLastModified(new Date());
        return r;
    }

    @Ignore
    public static Rocket Map(@NonNull LauncherConfigDetail c) {
        Rocket r = new Rocket();
        r.setRid(c.getId());
        r.setName(c.getName());
        r.setFamilyName(c.getFamily());
        r.setConfiguration(c.getFullName());
        r.setImageURL(c.getImageUrl());
        if (c.getWikiUrl() != null) {
            r.setWikiURL(c.getWikiUrl());
        }
        if (c.getInfoUrl() != null) {
            r.setInfoURLs(new String[]{c.getInfoUrl()});
        }
        r.setLastModified(new Date());
        return r;
    }

    @Ignore
    @Override
    public String toString() {
        return "rid: " + rid + "\n" +
                "name: " + name + "\n" +
                "familyName: " + familyName + "\n" +
                "configuration: " + configuration + "\n" +
                "imageURL: " + imageURL + "\n" +
                "wikiURL: " + wikiURL + "\n" +
                "infoURLs: " + (infoURLs == null ? 0 : infoURLs.length) + "\n" +
                "lastModified: " + lastModified;

    }
}