package models;

import models.base.BaseObj;

@SuppressWarnings("SpellCheckingInspection")
class LaunchEvent extends BaseObj {
    private int relativeTime;
    private int type;
    private int duration;
    private String description;
    private int parentid;

    public int getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(int relativeTime) {
        this.relativeTime = relativeTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }
}
