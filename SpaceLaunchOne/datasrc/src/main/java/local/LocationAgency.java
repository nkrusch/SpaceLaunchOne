package local;

import android.util.ArrayMap;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "locationagency",
        primaryKeys = {"lid", "aid"},
        indices = {
                @Index(value = {"aid"}),
                @Index(value = {"lid"})
        })
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

    public static String key(int lid, int aid) {
        return String.format("%d,%d", lid, aid);
    }

    @Ignore
    public static void Map(ArrayMap<String, LocationAgency> ref, final int locationId, models.Pad[] pads, models.Agency ag) {
        if (locationId < 1) return;

        if (ag != null && ag.getId() > 0) {
            String key = key(locationId, ag.getId());
            if (!ref.containsKey(key)) ref.put(key, new LocationAgency(locationId, ag.getId()));
        }
        if (pads == null) return;

        for (models.Pad pad : pads) {
            if (pad.getAgencies() == null) continue;
            for (models.Agency agency : pad.getAgencies()) {
                String k = key(locationId, agency.getId());
                if (!ref.containsKey(k) && agency.getId() > 0)
                    ref.put(k, new LocationAgency(locationId, agency.getId()));
            }
        }
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("location: %d agency: %d", lid, aid);
    }
}
