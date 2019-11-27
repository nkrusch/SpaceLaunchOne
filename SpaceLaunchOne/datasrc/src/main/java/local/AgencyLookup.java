package local;

import androidx.room.ColumnInfo;

@SuppressWarnings("SpellCheckingInspection")
public class AgencyLookup implements IFilter {

    @ColumnInfo(name = "agencyName")
    private
    String name;

    @ColumnInfo(name = "agencyImage")
    private
    String agencyImage;

    @ColumnInfo(name = "agencyCountryCode")
    private
    String agencyCountryCode;

    @ColumnInfo(name = "agencyId")
    private
    int id;

    @ColumnInfo(name = "afid")
    private
    int afid;

    public AgencyLookup() {
    }

    public AgencyLookup(int id, String name) {
        this.name = name;
        this.id = id;
        afid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgencyImage() {
        return agencyImage;
    }

    public void setAgencyImage(String agencyImage) {
        this.agencyImage = agencyImage;
    }

    public String getAgencyCountryCode() {
        return agencyCountryCode;
    }

    public void setAgencyCountryCode(String agencyCountryCode) {
        this.agencyCountryCode = agencyCountryCode;
    }

    public void setAfid(int afid) {
        this.afid = afid;
    }

    public int getAfid() {
        return afid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFiltered() {
        return id == afid;
    }
}
