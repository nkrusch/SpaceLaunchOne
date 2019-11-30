package local;

import android.util.ArrayMap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("NullableProblems")
@Entity(tableName = "mission", indices = {@Index("launchId")})
public class Mission {

    @NonNull
    @PrimaryKey()
    private int mid;
    private int launchId;
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

    public int getLaunchId() {
        return launchId;
    }

    public void setLaunchId(int launchId) {
        this.launchId = launchId;
    }

    @Ignore
    public static Mission Map(int launchId, models.Mission mission) {
        Mission m = new Mission();
        m.setMid(mission.getId());
        m.setLaunchId(launchId);
        m.setCategory(mission.getTypeName());
        m.setDescription(mission.getDescription());
        m.setWikiURL(mission.getWikiURL());
        m.setName(mission.getName());
        return m;
    }

    @Ignore
    public static List<Mission> Map(int launchId, models.Mission[] missions) {
        List<Mission> result = new LinkedList<>();
        if (missions != null) {
            for (models.Mission mission : missions)
                result.add(Map(launchId, mission));
        }
        return result;
    }

    @Ignore
    public static void Map(ArrayMap<Integer, Mission> result, int launchId, models.Mission[] missions) {
        if (missions == null || missions.length == 0) return;
        for (models.Mission m : missions) {
            if (result.containsKey(m.getId())) continue;
            result.put(m.getId(), Map(launchId, m));
        }
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
