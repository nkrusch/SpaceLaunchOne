package local;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import models.Location;

@SuppressWarnings("NullableProblems")
@Entity(tableName = "launch", indices = {@Index("launchDateUTC")})
public class Launch {

    @NonNull
    @PrimaryKey()
    private int id;
    private String name;
    private String image;
    private Long launchDateUTC;
    private String locationName;
    private int status;

    public Launch(){}

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getLaunchDateUTC() {
        return launchDateUTC;
    }

    public void setLaunchDateUTC(Long launchDateUTC) {
        this.launchDateUTC = launchDateUTC;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Ignore
    public String getStatusText() {
        switch (status) {
            case 1:
                return "Go";
            case 2:
                return "No-Go";
            case 3:
                return "Success";
            case 4:
                return "Failed";
            case 5:
                return "Hold";
            case 6:
                return "In Flight";
            case 7:
                return "Partial Failure";
            default:
                return "Unknown";
        }
    }

    @Ignore
    public String getStatusColor(){
        switch (status) {
            case 1:
                return "#55D400";  // go
            case 2:
                return "#ff0000"; // no go
            case 3:
                return "#4CAF50"; // success
            case 4:
                return "#FFFF0000"; // fail
            case 5:
                return "#CD4EED"; // hold
            case 6:
                return "#42bcf4"; // in flight
            case 7:
                return "#FFA726"; // partial fail
            default:
                return "#00FFFFFF"; // unknown
        }
    }

    @Ignore
    public static Launch Map(models.Launch launch) {
        Launch r = new Launch();
        Location l = launch.getLocation();
        r.setId(launch.getId());
        r.setName(launch.getName());
        r.setImage(launch.getImage());
        r.setLaunchDateUTC(launch.getLaunchDateUTC());
        r.setLocationName(l != null ? l.getName() : null);
        r.setStatus(launch.getStatus());
        return r;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "name: " + name + "\n" +
                "image: " + image + "\n" +
                "launchDateUTC: " + launchDateUTC + "\n" +
                "locationName: " + locationName + "\n" +
                "status: " + status;
    }
}