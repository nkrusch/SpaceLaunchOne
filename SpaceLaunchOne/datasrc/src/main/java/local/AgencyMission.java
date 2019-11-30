package local;

import android.util.ArrayMap;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "agencymission",
        primaryKeys = {"mid", "aid"},
        indices = {@Index(value = {"mid"})})
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

    @Ignore
    public static void Map(ArrayMap<String, AgencyMission> ref, models.Mission[] missions) {
        if (missions == null || missions.length == 0) return;

        for (models.Mission mission : missions) {
            int mid = mission.getId();
            if (mission.getAgencies() != null && mission.getAgencies().length > 0)
                for (models.Agency agency : mission.getAgencies()) {
                    String key = String.valueOf(mid + ',' + agency.getId());
                    if (ref.containsKey(key) || mid < 1 || agency.getId() < 1) continue;
                    ref.put(key, new AgencyMission(mid, agency.getId()));
                }
        }
    }
}
