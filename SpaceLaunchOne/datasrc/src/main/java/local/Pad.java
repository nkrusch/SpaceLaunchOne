package local;

import android.util.ArrayMap;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    private Double latitude;
    private Double longitude;
    private int retired;
    private int locationId;
    private String[] infoURLs;
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
        a.setLatitude(pad.getLatitude());
        a.setLongitude(pad.getLongitude());
        a.setRetired(pad.getRetired());
        a.setLocationId(pad.getLocationid());
        if (pad.getWikiURL() != null && !pad.getWikiURL().isEmpty()) {
            List<String> tmp = new LinkedList<>();
            tmp.add(pad.getWikiURL());
            if (pad.getInfoURLs() != null && pad.getInfoURLs().length > 0)
                tmp.addAll(Arrays.asList(pad.getInfoURLs()));
            a.setInfoURLs(tmp.toArray(new String[0]));
        } else if (pad.getInfoURLs() != null && pad.getInfoURLs().length > 0)
            a.setInfoURLs(pad.getInfoURLs());
        a.setChanged(pad.getChanged());
        a.setLastModified(new Date());
        return a;
    }

    public static void Map(ArrayMap<Integer, Pad> pads, models.Pad[] padArray) {
        if (padArray != null && padArray.length > 0) {
            for (models.Pad pad : padArray)
                if (!pads.containsKey(pad.getId()))
                    pads.put(pad.getId(), Map(pad));
        }
    }

    @Ignore
    @Override
    public String toString() {
        return "pid: " + pid + "\n" +
                "name: " + name + "\n" +
                "latitude: " + latitude + "\n" +
                "longitude: " + longitude + "\n" +
                "retired: " + retired + "\n" +
                "locationId: " + locationId + "\n" +
                "infoURLs: " + Arrays.toString(infoURLs) + "\n" +
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
