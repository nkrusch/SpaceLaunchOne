package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@SuppressWarnings({"SpellCheckingInspection", "NullableProblems"})
@Entity(tableName = "agencyFilter")
public class AgencyFilter {

    @NonNull
    @PrimaryKey
    private
    int afid;

    public AgencyFilter() {
    }

    public AgencyFilter(int id) {
        this.afid = id;
    }

    public int getAfid() {
        return afid;
    }

    public void setAfid(int afid) {
        this.afid = afid;
    }
}
