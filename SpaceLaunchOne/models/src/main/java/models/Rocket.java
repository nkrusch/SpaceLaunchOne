package models;

import java.util.LinkedList;
import java.util.List;

import jdk.nashorn.internal.ir.annotations.Ignore;
import models.base.InfoObj;

@SuppressWarnings("SpellCheckingInspection")
public class Rocket extends InfoObj {

    private RocketFamily family;
    private String defaultPads;
    private String imageURL;
    private String familyname;
    private String configuration;
    private int[] imageSizes;

    // used internally while resolving images
    private List<Integer> launchIds = new LinkedList<>();

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getFamilyName() {
        return familyname;
    }

    public void setFamilyName(String familyName) {
        this.familyname = familyName;
    }

    public String getDefaultPads() {
        return defaultPads;
    }

    public void setDefaultPads(String defaultPads) {
        this.defaultPads = defaultPads;
    }

    public RocketFamily getFamily() {
        return family;
    }

    public void setFamily(RocketFamily family) {
        this.family = family;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int[] getImageSizes() {
        return imageSizes;
    }

    public void setImageSizes(int[] imageSizes) {
        this.imageSizes = imageSizes;
    }

    public List<Integer> getLaunchIds() {
        return launchIds;
    }

    public void setLaunchIds(List<Integer> launchIds) {
        this.launchIds = launchIds;
    }
    public void addLaunchId(Integer launchId){
        this.launchIds.add(launchId);
    }
}