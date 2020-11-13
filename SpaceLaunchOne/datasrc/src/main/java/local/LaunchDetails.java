package local;

import java.util.Date;
import java.util.List;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

@SuppressWarnings("SpellCheckingInspection")
public class LaunchDetails {

    @Embedded
    private Launch summary;

    @Embedded
    private Details detail;


    @Relation(parentColumn = "agencyId", entityColumn = "aid")
    private Agency agency;

    @Relation(parentColumn = "locationId", entityColumn = "lid")
    private Location location;

    @Relation(parentColumn = "padId", entityColumn = "pid")
    private Pad pad;

    @Relation(parentColumn = "rocketId", entityColumn = "rid")
    private Rocket rocket;

    @Relation(parentColumn = "luuid", entityColumn = "launchId")
    private List<Mission> missions;

    @Ignore
    public LaunchDetails() {
    }

    public LaunchDetails(Launch summary, Details detail, List<Mission> missions, Agency agency, Location location, Pad pad, Rocket rocket) {
        this.detail = detail;
        this.summary = summary;
        this.missions = missions;
        this.agency = agency;
        this.location = location;
        this.rocket = rocket;
        this.pad = pad;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public Launch getSummary() {
        return summary;
    }

    public void setSummary(Launch summary) {
        this.summary = summary;
    }

    public Details getDetail() {
        return detail;
    }

    public void setDetail(Details detail) {
        this.detail = detail;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Pad getPad() {
        return pad;
    }

    public void setPad(Pad pad) {
        this.pad = pad;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public String getName() {
        return summary.getName();
    }

    public String getImage() {
        return summary.getImage();
    }

    public Long getLaunchDateUTC() {
        return summary.getLaunchDateUTC();
    }

    public String getLocationName() {
        return summary.getLocationName();
    }

    public int getStatus() {
        return summary.getStatus();
    }

    public String getStatusText() {
        return summary.getStatusText();
    }

    public int getAgencyId() {
        return agency == null ? 0 : agency.getAid();
    }

    public String getAgencyName() {
        return agency == null ? null : agency.getName();
    }

    public String getAgencyCountryCode() {
        return agency == null ? null : agency.getCountryCode();
    }

    public String getAgencyAbbrev() {
        return agency == null ? null : agency.getAbbrev();
    }

    public String getAgencyWikiURL() {
        return agency == null ? null : agency.getWikiURL();
    }

    public String[] getAgencyInfoURLs() {
        return agency == null ? null : agency.getInfoURLs();
    }

    public String getRocketName() {
        return rocket == null ? null : rocket.getName();
    }

    public String getRocketFamilyName() {
        return rocket == null ? null : rocket.getFamilyName();
    }

    public String getRocketConfiguration() {
        return rocket == null ? null : rocket.getConfiguration();
    }

    public String getRocketWikiURL() {
        return rocket == null ? null : rocket.getWikiURL();
    }

    public String[] getRocketInfoURLs() {
        return rocket == null ? null : rocket.getInfoURLs();
    }

    public int getLocationId() {
        return detail.getLocationId();
    }

    public String getLocationCountryCode() {
        return location == null ? null :
                location.getCountryCode().replace("UNK", "");
    }

    public String getPadName() {
        return pad == null ? null : pad.getName();
    }

    public String[] getPadInfoURLs() {
        return pad == null ? null : pad.getInfoURLs();
    }

    public Double getLatitude() {
        return pad == null ? 0 : pad.getLatitude();
    }

    public Double getLongitude() {
        return pad == null ? 0 : pad.getLongitude();
    }

    public String getChanged() {
        return detail.getChanged();
    }

    public String[] getVidURLs() {
        return detail.getVidURLs();
    }

    public String getHashtag() {
        return detail.getHashtag();
    }

    public String getNet() {
        return detail.getNet();
    }

    public Date getLasModified() {
        return detail.getLastModified();
    }

    @Override
    public String toString() {
        return "LaunchDetails{" +
                "summary=" + summary +
                ", detail=" + detail +
                ", agency=" + agency +
                ", location=" + location +
                ", pad=" + pad +
                ", rocket=" + rocket +
                ", missions=" + missions +
                '}';
    }
}
