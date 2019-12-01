package local;

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
import models.Location;
import models.Rocket;


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
    private int uid;
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
    public static Details Map(models.Launch launch) {

        Details details = new Details();
        Location location = launch.getLocation();
        Rocket rocket = launch.getRocket();
        Agency agency = launch.getLsp();

        details.setUid(launch.getId());
        details.setHashtag(launch.getHashtag());
        details.setChanged(launch.getChanged());
        details.setNet(launch.getNet());
        details.setVidURLs(launch.getVidURLs());

        if (launch.getWikiURL() != null && !launch.getWikiURL().isEmpty()) {
            List<String> tmp = new LinkedList<>();
            tmp.add(launch.getWikiURL());
            if (launch.getInfoURLs() != null && launch.getInfoURLs().length > 0)
                tmp.addAll(Arrays.asList(launch.getInfoURLs()));
            details.setInfoURLs(tmp.toArray(new String[0]));
        } else details.setInfoURLs(launch.getInfoURLs());

        if (agency != null)
            details.setAgencyId(agency.getId());

        if (location != null)
            details.setLocationId(location.getId());

        if (location != null && location.getPad() != null)
            details.setPadId(location.getPad().getId());

        if (rocket != null)
            details.setRocketId(rocket.getId());

        if (details.getLocationId() > 0 && details.getAgencyId() > 0 && details.getRocketId() > 0)
            details.setLastModified(new Date());

        return details;
    }

    @Ignore
    @Override
    public String toString() {
        return "id:" + getUid() + "\n" +
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