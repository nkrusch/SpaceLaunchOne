package local;

import java.util.Collections;
import java.util.List;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Junction;
import androidx.room.Relation;

public class AgencyDetails {

    @Embedded
    Agency agency;


    @Relation(
            parentColumn = "aid",
            entityColumn = "luuid",
            entity = Launch.class,
            associateBy = @Junction(value = Details.class, parentColumn = "agencyId", entityColumn = "UUID"))
    private
    List<Launch> launches;

    @Relation(
            parentColumn = "aid",
            entityColumn = "mid",
            entity = Mission.class,
            associateBy = @Junction(value = AgencyMission.class, parentColumn = "aid", entityColumn = "mid"))
    private
    List<Mission> missions;

    @Ignore
    public AgencyDetails() {
    }

    public AgencyDetails(Agency agency, List<Launch> launches, List<Mission> missions) {
        this.agency = agency;
        this.launches = launches;
        this.missions = missions;
    }


    public Agency getAgency() {
        return agency;
    }

    public List<Launch> getLaunches() {
        Collections.sort(launches);
        return launches;
    }

    public List<Mission> getMissions(){
        return missions;
    }
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }


}
