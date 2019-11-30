package models;

import java.util.LinkedList;
import java.util.List;

import models.base.PagedResult;

public class Launches extends PagedResult {

    private List<Launch> launches = new LinkedList<>();

    public List<Launch> getLaunches() {
        return launches;
    }

    public void setLaunches(List<Launch> launches) {
        this.launches = launches;
    }

    public Launches(){}

    public Launches(Launch launch){
        this.launches.add(launch);
    }
}
