package models;

import java.util.LinkedList;
import java.util.List;

import models.base.PagedResult;

public class Locations extends PagedResult {

    private List<Location> locations = new LinkedList<>();

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
