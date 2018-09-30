package models.base;

public abstract class EventObj extends BaseObj {

    private String description;
    private int relativeTime;
    private int parentId;
    private int duration;
    private int type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(int relativeTime) {
        this.relativeTime = relativeTime;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
