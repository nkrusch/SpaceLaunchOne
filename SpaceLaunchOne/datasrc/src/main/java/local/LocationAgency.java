package local;

import android.annotation.SuppressLint;
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

    @SuppressLint("DefaultLocale")
    public static String key(int lid, int aid) {
        return String.format("%d,%d", lid, aid);
    }

    @Ignore
    public static void Map(ArrayMap<String, LocationAgency> ref, final int locationId, int agencyId) {
        if (locationId < 1 || agencyId < 1) return;
        String key = key(locationId, agencyId);
        if (!ref.containsKey(key)) ref.put(key, new LocationAgency(locationId, agencyId));
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public String toString() {
        return String.format("location: %d agency: %d", lid, aid);
    }
}
