package models;

import java.util.LinkedList;
import java.util.List;

import models.base.PagedResult;

public class Missions extends PagedResult {

    private List<Mission> missions = new LinkedList<>();

    public List<Mission> getLaunches() {
        return missions;
    }

    public void setLaunches(List<Mission> launches) {
        this.missions = launches;
    }
}
