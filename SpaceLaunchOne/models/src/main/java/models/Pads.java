package models;

import java.util.LinkedList;
import java.util.List;

import models.base.PagedResult;

public class Pads extends PagedResult {

    private List<Pad> pads = new LinkedList<>();

    public List<Pad> getPads() {
        return pads;
    }

    public void setPads(List<Pad> pads) {
        this.pads = pads;
    }
}
