package local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

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
