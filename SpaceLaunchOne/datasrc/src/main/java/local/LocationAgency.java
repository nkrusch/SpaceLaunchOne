package local;

import android.util.ArrayMap;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import ll2.models.AgencySerializerMini;
import ll2.models.Pad;

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
    public static void Map(ArrayMap<String, LocationAgency> ref, final int locationId, Pad pad, AgencySerializerMini ag) {
        if (locationId < 1) return;
        if (ag != null && ag.getId() > 0) {
            String key = key(locationId, ag.getId());
            if (!ref.containsKey(key)) ref.put(key, new LocationAgency(locationId, ag.getId()));
        }
        if (pad == null || pad.getAgencyId() == null) return;
        String k = key(locationId, pad.getAgencyId());
        if (!ref.containsKey(k) && pad.getAgencyId() > 0)
            ref.put(k, new LocationAgency(locationId, pad.getAgencyId()));
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("location: %d agency: %d", lid, aid);
    }
}
