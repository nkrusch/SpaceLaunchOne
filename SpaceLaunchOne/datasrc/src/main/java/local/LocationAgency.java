package local;

import android.util.ArrayMap;

import java.util.LinkedList;
import java.util.List;

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


    @Ignore
    public static void Map(ArrayMap<String, LocationAgency> ref, final int locationId, models.Pad[] pads, models.Agency ag) {
        if (pads == null || pads.length == 0 || locationId < 1) return;
        for (models.Pad pad : pads) {
            if (pad.getAgencies() != null && pad.getAgencies().length > 0)
                for (models.Agency agency : pad.getAgencies()) {
                    String key = String.valueOf(locationId + ',' + agency.getId());
                    if (ref.containsKey(key) || agency.getId() < 1) continue;
                    ref.put(key, new LocationAgency(locationId, agency.getId()));
                }
        }
        if (ag != null) {
            String key = String.valueOf(locationId + ',' + ag.getId());
            if (ref.containsKey(key) || ag.getId() < 1) return;
            ref.put(key, new LocationAgency(locationId, ag.getId()));
        }
    }
}
