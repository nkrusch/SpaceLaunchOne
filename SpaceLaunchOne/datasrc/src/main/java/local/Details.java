package local;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import ll2.models.AgencySerializerMini;
import ll2.models.LaunchSerializerCommon;
import ll2.models.Program;
import ll2.models.RocketSerializerCommon;


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
    private String UUID;
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
    public static Details Map(LaunchSerializerCommon launch) {

        Details details = new Details();
        final RocketSerializerCommon rocket = launch.getRocket();
        final AgencySerializerMini agency = launch.getLaunchServiceProvider();
        final ll2.models.Pad pad = launch.getPad();

        details.setUUID(launch.getId().toString());
        details.setHashtag(launch.getHashtag());
        details.setChanged(new Date().toString());
        details.setNet(launch.getNet().toString());
        if (launch.getVidURLs() != null) details.setVidURLs(new String[]{launch.getVidURLs()});
        if (agency != null) details.setAgencyId(agency.getId());
        if (pad != null && pad.getLocation() != null) details.setLocationId(pad.getLocation().getId());
        if (pad != null) details.setPadId(pad.getId());
        if (rocket != null) details.setRocketId(rocket.getId());
         details.setLastModified(new Date());

        final List<String> infoURLs = new ArrayList<>();
        if (launch.getProgram() != null && launch.getProgram().size() > 0)
            for (Program p : launch.getProgram()) {
                if (p.getWikiUrl() != null) infoURLs.add(p.getWikiUrl());
                if (p.getInfoUrl() != null) infoURLs.add(p.getInfoUrl());
            }
        if (launch.getPad() != null) {
            if (launch.getPad().getInfoUrl() != null) infoURLs.add(launch.getPad().getInfoUrl());
            if (launch.getPad().getWikiUrl() != null) infoURLs.add(launch.getPad().getWikiUrl());
        }

        details.setInfoURLs(infoURLs.toArray(new String[0]));

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