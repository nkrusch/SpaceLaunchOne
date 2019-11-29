package local;

import androidx.room.Embedded;
import androidx.room.Ignore;

public class AgencyDetails {

    @Embedded
    Agency agency;


    @Ignore
    public AgencyDetails() {
    }

    public AgencyDetails(Agency agency) {
        this.agency = agency;
    }

}
