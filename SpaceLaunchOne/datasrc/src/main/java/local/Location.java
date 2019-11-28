package local;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "locations")
public class Location {

    @NonNull
    @PrimaryKey()
    private int lid;
    private String name;
    private String countryCode;
    private String[] infoURLs;
    private String wikiURL;
    private String changed;
    private Date lastModified;


    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Ignore
    public static Location Map(models.Location loc) {
        Location a = new Location();

        a.setLid(loc.getId());
        a.setName(loc.getName());
        a.setCountryCode(loc.getCountryCode());
        if(a.getCountryCode() == null)
            a.setCountryCode(loc.getCountrycode());
        a.setInfoURLs(loc.getInfoURLs());
        a.setWikiURL(loc.getWikiURL());
        a.setChanged(loc.getChanged());
        a.setLastModified(new Date());
        return a;
    }

    @Ignore
    @Override
    public String toString() {
        return "lid: " + lid + "\n" +
                "name: " + name + "\n" +
                "countryCode: " + countryCode + "\n" +
                "infoURLs: " + infoURLs + "\n" +
                "wikiURL: " + wikiURL + "\n" +
                "changed: " + changed + "\n";
    }
}
