package local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

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
