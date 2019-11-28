package models;

import java.util.LinkedList;
import java.util.List;

import models.base.PagedResult;

public class Agencies extends PagedResult {

    private List<Agency> agencies = new LinkedList<>();

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }
}
