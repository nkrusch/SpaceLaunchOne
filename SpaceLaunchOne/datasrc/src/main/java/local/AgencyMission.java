package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "agencymission",
        primaryKeys = {"mid", "aid"},
        indices = {
                @Index(value = {"mid"}),
                @Index(value = {"aid"})
        })
public class AgencyMission {


    @NonNull
    private int mid;
    @NonNull
    private int aid;

    @Ignore
    public AgencyMission() {
    }

    public AgencyMission(int mid, int aid) {
        this.mid = mid;
        this.aid = aid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int lid) {
        this.mid = lid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public static String key(int mid, int aid) {
        return String.format("%d,%d", mid, aid);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("mission: %d agency: %d", mid, aid);
    }
}
