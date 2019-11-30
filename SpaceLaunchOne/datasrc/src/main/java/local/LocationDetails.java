package local;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Junction;
import androidx.room.Relation;

public class LocationDetails {

    @Embedded
    Location location;

    @Relation(parentColumn = "lid", entityColumn = "locationId")
    List<Pad> pads;

    @Relation(
            parentColumn = "lid",
            entityColumn = "id",
            entity = Launch.class,
            associateBy = @Junction(value = Details.class, parentColumn = "locationId", entityColumn = "uid"))
    List<Launch> launches;

    @Relation(
            parentColumn = "lid",
            entityColumn = "aid",
            entity = Agency.class,
            associateBy = @Junction(value = LocationAgency.class, parentColumn = "lid", entityColumn = "aid"))
    List<Agency> agencies = new LinkedList<>();

    @Ignore
    public LocationDetails() {
    }

    public LocationDetails(Location location, List<Launch> launches, List<Pad> pads, List<Agency> agencies) {
        this.location = location;
        this.launches = launches;
        this.agencies = agencies;
        this.pads = pads;
    }

    public Location getLocation() {
        return location;
    }

    public List<Launch> getLaunches() {
        Collections.sort(launches);
        return launches;
    }

    public List<Pad> getPads() {
        Collections.sort(pads);
        return pads;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }
}
