package local;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Junction;
import androidx.room.Relation;

public class LocationDetails {

    @Embedded
    Location location;

    @Relation(
            parentColumn = "lid",
            entityColumn = "id",
            entity = Launch.class,
            associateBy = @Junction(value = Details.class, parentColumn = "locationId", entityColumn = "uid"))
    List<Launch> launches;

    @Relation(parentColumn = "lid", entityColumn = "locationId")
    List<Pad> pads;

    @Ignore
    public LocationDetails() {
    }

    public LocationDetails(Location location, List<Launch> launches, List<Pad> pads) {
        this.location = location;
        this.launches = launches;
        this.pads = pads;
    }

    public Location getLocation() {
        return location;
    }

    public List<Launch> getLaunches() {
        return launches;
    }

    public List<Pad> getPads() {
        return pads;
    }

    @NonNull
    @Override
    public String toString() {
        return location.toString() + "\npads: " + pads.size() + "\nlaunches: " + launches.size();
    }
}
