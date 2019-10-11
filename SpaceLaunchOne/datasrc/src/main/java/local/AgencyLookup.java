package local;

import androidx.room.ColumnInfo;

@SuppressWarnings("SpellCheckingInspection")
public class AgencyLookup implements IFilter {

    @ColumnInfo(name = "agencyName")
    private
    String name;

    @ColumnInfo(name = "agencyId")
    private
    int id;


    @ColumnInfo(name = "afid")
    private
    int afid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAfid(int afid) {
        this.afid = afid;
    }

    public int getAfid() { return afid; }

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
