package local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("NullableProblems")
@Entity(tableName = "mission", indices = {@Index("launchId")})
public class Mission {

    @NonNull
    @PrimaryKey()
    private int mid;
    private String description;
    private String category;
    private int launchId;
    private String wikiURL;
    private String name;

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

    public int getLaunchId() {
        return launchId;
    }

    public void setLaunchId(int launchId) {
        this.launchId = launchId;
    }

    @Ignore
    public static List<Mission> Map(int launchId, models.Mission[] missions) {
        List<Mission> result = new LinkedList<>();
        if (missions != null) {
            for (models.Mission mission : missions) {
                Mission m = new Mission();
                m.setMid(mission.getId());
                m.setLaunchId(launchId);
                m.setCategory(mission.getTypeName());
                m.setDescription(mission.getDescription());
                m.setWikiURL(mission.getWikiURL());
                m.setName(mission.getName());
                result.add(m);
            }
        }
        return result;
    }

    @Ignore
    public static List<local.Mission> Map(int launchId, List<models.Mission> missions) {
        models.Mission[] missionArray = missions.toArray(new models.Mission[missions.size()]);
        return Map(launchId, missionArray);
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
