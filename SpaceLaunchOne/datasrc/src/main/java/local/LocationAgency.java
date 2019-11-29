package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "locationagency",
        primaryKeys = {"lid", "aid"},
        indices = {@Index(value = {"aid"})})
public class LocationAgency {


    @NonNull
    private int lid;
    @NonNull
    private int aid;

    @Ignore
    public LocationAgency() {
    }

    public LocationAgency(int lid, int aid) {
        this.lid = lid;
        this.aid = aid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
