package local;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.Date;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class LaunchDetails {

    @Embedded
    Launch summary;

    @Embedded
    Details detail;

    @Relation(parentColumn = "id", entityColumn = "launchId")
    private
    List<Mission> missions;

    public LaunchDetails() {
    }

    public LaunchDetails(Launch summary, Details detail, List<Mission> missions) {
        this.detail = detail;
        this.summary = summary;
        this.missions = missions;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public int getId() {
        return summary.getId();
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
        return detail.getAgencyId();
    }

    public String getAgencyName() {
        return detail.getAgencyName();
    }

    public String getAgencyCountryCode() {
        return detail.getAgencyCountryCode();
    }

    public String getAgencyAbbrev() {
        return detail.getAgencyAbbrev();
    }

    public String getAgencyWikiURL() {
        return detail.getAgencyWikiURL();
    }

    public String[] getAgencyInfoURLs() {
        return detail.getAgencyInfoURLs();
    }

    public int getRocketId() {
        return detail.getRocketId();
    }

    public String getRocketName() {
        return detail.getRocketName();
    }

    public String getRocketFamilyName() {
        return detail.getRocketFamilyName();
    }

    public String getRocketConfiguration() {
        return detail.getRocketConfiguration();
    }

    public String getRocketWikiURL() {
        return detail.getRocketWikiURL();
    }

    public String[] getRocketInfoURLs() {
        return detail.getRocketInfoURLs();
    }

    public int getLocationId() {
        return detail.getLocationId();
    }

    public String getLocationCountryCode() {
        return detail.getLocationCountryCode();
    }

    public String getLocationWikiURL() {
        return detail.getLocationWikiURL();
    }

    public String[] getLocationURLs() {
        return detail.getLocationURLs();
    }

    public int getPadId() {
        return detail.getPadId();
    }

    public String getPadName() {
        return detail.getPadName();
    }

    public String getPadWikiURL() {
        return detail.getPadWikiURL();
    }

    public String[] getPadInfoURLs() {
        return detail.getPadInfoURLs();
    }

    public Double getLatitude() {
        return detail.getLatitude();
    }

    public Double getLongitude() {
        return detail.getLongitude();
    }

    public String getChanged() {
        return detail.getChanged();
    }

    public String[] getVidURLs() {
        return detail.getVidURLs();
    }

    public String[] getInfoURLs() {
        return detail.getInfoURLs();
    }

    public String getWikiURL() {
        return detail.getWikiURL();
    }

    public String getHashtag() {
        return detail.getHashtag();
    }

    public String getNet() {
        return detail.getNet();
    }

    public String getAgencyImage() {
        return detail.getAgencyImage();
    }

    public Date getLasModified() {
        return detail.getLastModified();
    }

    private String regexSplit(String value, String separator) {
        if (value != null) {
            String[] parts = value.split(separator);
            if (parts.length > 0) return parts[0].trim();
        }
        return "";
    }

    public String getLaunchShortName() {
        return regexSplit(getName(), "|");
    }

    public String getPadShortName() {
        return regexSplit(getPadName(), ",");
    }

    public String getAgencyShortName() {
        return (getAgencyName() == null ||
                getAgencyName().length() < 1 ||
                getAgencyName().length() > 30) ?
                getAgencyAbbrev() : getAgencyName();
    }
}
