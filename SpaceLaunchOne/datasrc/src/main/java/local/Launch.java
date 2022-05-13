package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import models.LaunchDetailed;
import models.Pad;

@SuppressWarnings("NullableProblems")
@Entity(tableName = "launch", indices = {@Index("launchDateUTC")})
public class Launch implements Comparable<Launch> {

    @NonNull
    @PrimaryKey()
    private String luuid = "";
    private String name;
    private String image;
    private Long launchDateUTC;
    private String locationName;
    private int status;

    public Launch() {
    }

    @NonNull
    public String getLuuid() {
        return luuid;
    }

    public void setLuuid(@NonNull String luuid) {
        this.luuid = luuid;
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


    private static String locationName(Pad pad) {
        if (pad == null) return null;
        if (pad.getLocation() != null) return pad.getLocation().getName();
        return pad.getName();
    }

    @Ignore
    public static Launch Map(@NonNull LaunchDetailed launch) {
        Launch r = new Launch();
        r.setLuuid(launch.getId().toString());
        r.setName(launch.getName());
        r.setImage(launch.getImage());
        r.setLaunchDateUTC(launch.getNet().toEpochSecond());
        r.setLocationName(locationName(launch.getPad()));
        r.setStatus(launch.getStatus().getId());
        return r;
    }

    @Override
    public String toString() {
        return "id: " + getLuuid() + "\n" +
                "name: " + name + "\n" +
                "image: " + image + "\n" +
                "launchDateUTC: " + launchDateUTC + "\n" +
                "locationName: " + locationName + "\n" +
                "status: " + status;
    }

    @Override
    public int compareTo(Launch launch) {
        return this.launchDateUTC > launch.getLaunchDateUTC() ? -1 : 1;
    }
}
