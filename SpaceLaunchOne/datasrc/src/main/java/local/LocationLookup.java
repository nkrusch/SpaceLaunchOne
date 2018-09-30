package local;

import android.arch.persistence.room.ColumnInfo;

@SuppressWarnings("SpellCheckingInspection")
public class LocationLookup implements IFilter {

    @ColumnInfo(name = "locationName")
    private
    String name;

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
}
