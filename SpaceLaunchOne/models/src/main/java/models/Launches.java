package models;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

import models.base.PagedResult;

public class Launches extends PagedResult {

    @SerializedName("results")
    private List<Launch> results = new LinkedList<>();

    public List<Launch> getResults() {
        return this.results;
    }

    public void setResults(List<Launch> results) {
        this.results.addAll(results);
    }

    public Launches() {
    }

    public Launches(Launch launch) { this.results.add(launch); }
}
