package local;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import utilities.ImageResolver;

@SuppressWarnings("NullableProblems")
@Entity(tableName = "mission", indices = {@Index("launchId")})
public class Mission {

    @NonNull
    @PrimaryKey()
    private int mid;
    private String launchId;
    private String name;
    private String description;
    private String category;
    private String wikiURL;

    public Mission() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    @NonNull
    public int getMid() {
        return mid;
    }

    public void setMid(@NonNull int mid) {
        this.mid = mid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLaunchId() {
        return launchId;
    }

    public void setLaunchId(String launchId) {
        this.launchId = launchId;
    }

    public String getMissionImage() {
        return ImageResolver.resolveMissionImage(category);
    }

    @Ignore
    public String getIcon() {
        switch (category) {
            case "Astrophysics":
                return "\uD83C\uDF0C";
            case "Communications":
                return "☎️";
            case "Dedicated Rideshare":
                return "\uD83D\uDE96";
            case "Earth Science":
                return "\uD83C\uDF31";
            case "Government/Top Secret":
                return "\uD83D\uDCBC";
            case "Heliophysics":
                return "\uD83C\uDF1E";
            case "Human Exploration":
                return "\uD83D\uDC63";
            case "Planetary Science":
                return "\uD83D\uDEF0️";
            case "Resupply":
                return "⛽";
            case "Robotic Exploration":
                return "\uD83E\uDD16";
            case "Test Flight":
                return "\uD83D\uDEA7";
            case "Tourism":
                return "\uD83C\uDFD6️";
            case "Unknown":
                return "\uD83D\uDD2E";
            case "Navigation":
                return "\uD83E\uDDED";
            case "Microgravity Research":
                return "⚗️";
            case "Suborbital":
                return "\uD83D\uDD2D";
            default:
                return "";
        }
    }

    @Ignore
    public static Mission Map(String launchId, models.Mission mission) {
        Mission m = new Mission();
        m.setMid(mission.getId());
        m.setLaunchId(launchId);
        m.setCategory(mission.getType());
        m.setDescription(mission.getDescription());
        m.setName(mission.getName());
        return m;
    }

    @Override
    public String toString() {
        return "mid: " + getMid() + "\n" +
                "description: " + getDescription() + "\n" +
                "category: " + getCategory() + "\n" +
                "wikiUrl: " + getWikiURL() + "\n" +
                "launchId: " + getLaunchId();
    }
}
