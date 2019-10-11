package local;

import androidx.room.ColumnInfo;

@SuppressWarnings("SpellCheckingInspection")
public class RocketLookup implements IFilter {

    @ColumnInfo(name = "rocketName")
    private
    String name;

    @ColumnInfo(name = "rocketId")
    private
    int id;

    @ColumnInfo(name = "rfid")
    int rfid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRfied(int rfid) {
        this.rfid = rfid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFiltered() {
        return id == rfid;
    }
}
