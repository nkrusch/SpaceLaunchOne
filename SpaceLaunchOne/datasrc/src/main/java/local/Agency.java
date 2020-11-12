package local;

import java.util.Arrays;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import api.ImageResolver;
import ll2.models.AgencySerializerMini;

@Entity(tableName = "agencies")
public class Agency {

    @NonNull
    @PrimaryKey()
    private int aid;
    private String name;
    private String countryCode;
    private String abbrev;
    private int islsp;
    private int type;
    private String[] infoURLs;
    private String wikiURL;
    private String changed;
    private Date lastModified;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public int getIslsp() {
        return islsp;
    }

    public void setIslsp(int islsp) {
        this.islsp = islsp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return ImageResolver.resolveImage(aid);
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
    public String getAgencyType() {
        switch (type) {
            case 1:
                return "Government";
            case 2:
                return "Multinational";
            case 3:
                return "Commercial";
            case 4:
                return "Educational";
            case 5:
                return "Private";
            default:
                return "Unknown";
        }
    }

    @Ignore
    private static int getAgencyType(String input) {
        if (input == null) return -1;
        switch (input) {
            case "Government":
                return 1;
            case "Multinational":
                return 2;
            case "Commercial":
                return 3;
            case "Educational":
                return 4;
            case "Private":
                return 5;
            default:
                return -1;
        }
    }

    @Ignore
    public String getAgencyCountries() {
        if (countryCode == null || countryCode.isEmpty()) return "";
        if (!countryCode.contains(",")) return countryCode;
        String[] countries = countryCode.split(",");
        if (countries.length > 3)
            return countries.length + " countries";

        StringBuilder tmp = new StringBuilder();
        int counter = 0;
        for (String c : countries) {
            if (counter++ > 0) tmp.append(", ");
            tmp.append(c);
        }
        return tmp.toString();
    }

    @Ignore
    public static Agency Map(AgencySerializerMini agency) {
        Agency a = new Agency();
        a.setAid(agency.getId());
        a.setName(agency.getName());
        a.setType(getAgencyType(agency.getType()));
        a.setLastModified(new Date());
        return a;
    }

    @Ignore
    @Override
    public String toString() {
        return "aid: " + aid + "\n" +
                "name: " + name + "\n" +
                "countryCode: " + countryCode + "\n" +
                "abbrev: " + abbrev + "\n" +
                "islsp: " + islsp + "\n" +
                "type: " + type + "\n" +
                "image: " + getImage() + "\n" +
                "infoURLs: " + Arrays.toString(infoURLs) + "\n" +
                "wikiURL: " + wikiURL + "\n" +
                "changed: " + changed + "\n";
    }
}
