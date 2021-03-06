package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@SuppressWarnings({"NullableProblems"})
@Entity(tableName = "favorites")
public class FavoriteLaunch {

    @NonNull
    @PrimaryKey
    private String fid;

    public FavoriteLaunch() {
        fid = "";
    }

    public FavoriteLaunch(String id) {
        this.fid = id;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String id) {
        this.fid = id;
    }
}
