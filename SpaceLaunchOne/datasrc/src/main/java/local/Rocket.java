package local;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


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
    private List<Integer> launchIds = new LinkedList<>();

    @Ignore
    public List<Integer> getLaunchIds() {
        return launchIds;
    }

    @Ignore
    public void addLaunchId(Integer launchId) {
        this.launchIds.add(launchId);
    }

    @Ignore
    public static Rocket Map(models.Rocket rocket) {
        Rocket r = new Rocket();
        r.setRid(rocket.getId());
        r.setName(rocket.getName());
        r.setFamilyName(rocket.getFamilyName());
        r.setConfiguration(rocket.getConfiguration());
        r.setImageURL(rocket.getImageURL());
        r.setWikiURL(rocket.getWikiURL());
        r.setInfoURLs(rocket.getInfoURLs());
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