package local;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import models.InfoURL;
import models.LaunchDetailed;
import models.VidURL;


@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "details", indices = {
        @Index(value = {"rocketId"}),
        @Index(value = {"padId"}),
        @Index(value = {"agencyId"}),
        @Index(value = {"locationId"})
})
public class Details {

    @NonNull
    @PrimaryKey()
    private String UUID = "";
    private String net;
    private String hashtag;
    private String changed;
    private String[] vidURLs;
    private String[] infoURLs;
    private Date lastModified;

    private int agencyId;
    private int locationId;
    private int padId;
    private int rocketId;

    public Details() {
    }

    @NonNull
    public String getUUID() {
        return UUID;
    }

    public void setUUID(@NonNull String UUID) {
        this.UUID = UUID;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public int getRocketId() {
        return rocketId;
    }

    public void setRocketId(int rocketId) {
        this.rocketId = rocketId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getPadId() {
        return padId;
    }

    public void setPadId(int padId) {
        this.padId = padId;
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

    @Ignore
    public static Details Map(@NonNull LaunchDetailed launch) {

        Details details = new Details();
        details.setUUID(launch.getId().toString());
        details.setHashtag(launch.getHashtag());
        details.setChanged(new Date().toString());
        details.setNet(launch.getNet().toString());

        if (launch.getInfoURLs() != null && launch.getInfoURLs().size() > 0) {
            List<String> info = new LinkedList<>();
            for (InfoURL i : launch.getInfoURLs()) {
                info.add(i.getUrl());
            }
            details.setInfoURLs(info.toArray(new String[0]));
        }
        if (launch.getVidURLs() != null && launch.getVidURLs().size() > 0) {
            List<String> videos = new LinkedList<>();
            for (VidURL v : launch.getVidURLs()) {
                videos.add(v.getUrl());
            }
            details.setVidURLs(videos.toArray(new String[0]));
        }
        if (launch.getLaunchServiceProvider() != null) {
            details.setAgencyId(launch.getLaunchServiceProvider().getId());
        }
        if (launch.getPad() != null && launch.getPad().getLocation() != null) {
            details.setLocationId(launch.getPad().getLocation().getId());
        }
        if (launch.getPad() != null) {
            details.setPadId(launch.getPad().getId());
        }
        if (launch.getRocket() != null) {
            details.setRocketId(launch.getRocket().getConfiguration().getId());
        }
        details.setLastModified(new Date());
        return details;
    }

    @Ignore
    @Override
    public String toString() {
        return "id:" + getUUID() + "\n" +
                "hashtag:" + getHashtag() + "\n" +
                "changed:" + getChanged() + "\n" +
                "net:" + getNet() + "\n" +
                "videos:" + (getVidURLs() == null ? 0 : getVidURLs().length) + "\n" +
                "URLs:" + (getInfoURLs() == null ? 0 : getInfoURLs().length) + "\n" +
                "locationId:" + getLocationId() + "\n" +
                "agencyId:" + getAgencyId() + "\n" +
                "padId:" + getPadId() + "\n" +
                "rocketId:" + getRocketId() + "\n" +
                "last modiefied: " + getLastModified();
    }
}