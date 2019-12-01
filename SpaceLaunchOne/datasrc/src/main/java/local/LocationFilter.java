package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@SuppressWarnings({"SpellCheckingInspection", "NullableProblems"})
@Entity(tableName = "locationFilter")
public class LocationFilter {

    @NonNull
    @PrimaryKey
    private
    int pfid;

    public LocationFilter() {
    }

    public LocationFilter(int id) {
        this.pfid = id;
    }

    public int getPfid() {
        return pfid;
    }

    public void setPfid(int pfid) {
        this.pfid = pfid;
    }
}
