package local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@SuppressWarnings({"NullableProblems", "SpellCheckingInspection"})
@Entity(tableName = "rocketFilter")
public class RocketFilter {

    @NonNull
    @PrimaryKey
    private
    int rfid;

    public RocketFilter() {
    }

    public RocketFilter(int id) {
        this.rfid = id;
    }

    public int getRfid() {
        return rfid;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }
}
