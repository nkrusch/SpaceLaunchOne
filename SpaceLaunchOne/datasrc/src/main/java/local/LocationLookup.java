package local;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

@SuppressWarnings("SpellCheckingInspection")
public class LocationLookup implements IFilter {

    @ColumnInfo(name = "locationName")
    private
    String name;

    @ColumnInfo(name = "locationCountryCode")
    private
    String locationCountryCode;

    @ColumnInfo(name = "locationId")
    private
    int id;

    @ColumnInfo(name = "pfid")
    private
    int pfid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPfid(int pfid) {
        this.pfid = pfid;
    }

    public int getPfid() {
        return pfid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFiltered() {
        return id == pfid;
    }

    public String getLocationCountryCode() {
        return locationCountryCode;
    }

    public void setLocationCountryCode(String locationCountryCode) {
        this.locationCountryCode = locationCountryCode;
    }

    @Ignore
    public String getShortName() {
        if (name != null) {
            int splitAt = name.indexOf(",");
            if (splitAt > 0)
                return name.substring(0, splitAt).trim();
        }
        return name;
    }

    @Ignore
    public String getPlaceName() {
        if (name != null) {
            int splitAt = name.indexOf(",");
            if (splitAt > 0 && splitAt < name.length() - 1)
                return name.substring(splitAt + 1).trim();
        }
        return "";
    }
}
