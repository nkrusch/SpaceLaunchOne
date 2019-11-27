package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "FavoriteLaunch")
public class FavoriteLaunch {

    @NonNull
    @PrimaryKey
    private int fid;

    public FavoriteLaunch() {
    }

    public FavoriteLaunch(int id) {
        this.fid = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int id) {
        this.fid = id;
    }
}
