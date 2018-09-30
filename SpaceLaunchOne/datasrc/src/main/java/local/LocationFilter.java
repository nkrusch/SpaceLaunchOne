package local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

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
