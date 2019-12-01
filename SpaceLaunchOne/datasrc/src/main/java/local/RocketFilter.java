package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
