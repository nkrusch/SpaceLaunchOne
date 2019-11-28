package local;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import models.Agency;

@Entity(tableName = "pads",
        indices = {@Index(value = {"locationId"})})
public class Pad implements Comparable<Pad> {

    @NonNull
    @PrimaryKey()
    private int pid;
    private String name;
    private int padType;
    private Double latitude;
    private Double longitude;
    private String mapURL;
    private int retired;
    private int locationId;
    private String[] infoURLs;
    private String wikiURL;
    private String changed;
    private Date lastModified;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPadType() {
        return padType;
    }

    public void setPadType(int padType) {
        this.padType = padType;
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

    public String getMapURL() {
        return mapURL;
    }

    public void setMapURL(String mapURL) {
        this.mapURL = mapURL;
    }

    public boolean isRetired() {
        return this.retired == 1;
    }

    public int getRetired() {
        return retired;
    }

    public void setRetired(int retired) {
        this.retired = retired;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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
    public static Pad Map(models.Pad pad) {
        Pad a = new Pad();
        a.setPid(pad.getId());
        a.setName(pad.getName());
        a.setPadType(pad.getPadType());
        a.setLatitude(pad.getLatitude());
        a.setLongitude(pad.getLongitude());
        a.setMapURL(pad.getMapURL());
        a.setRetired(pad.getRetired());
        a.setLocationId(pad.getLocationid());
        a.setInfoURLs(pad.getInfoURLs());
        a.setWikiURL(pad.getWikiURL());
        a.setChanged(pad.getChanged());
        a.setLastModified(new Date());
        return a;
    }

    @Ignore
    @Override
    public String toString() {
        return "pid: " + pid + "\n" +
                "name: " + name + "\n" +
                "padType: " + padType + "\n" +
                "latitude: " + latitude + "\n" +
                "longitude: " + longitude + "\n" +
                "mapURL: " + mapURL + "\n" +
                "retired: " + retired + "\n" +
                "locationId: " + locationId + "\n" +
                "infoURLs: " + infoURLs + "\n" +
                "wikiURL: " + wikiURL + "\n" +
                "changed: " + changed + "\n" +
                "lastModified: " + lastModified;
    }

    @Ignore
    @Override
    public int compareTo(Pad pad) {
        if (isRetired() && !pad.isRetired()) return 1;
        if (!isRetired() && pad.isRetired()) return -1;
        return name.compareTo(pad.getName());
    }
}
