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
    private Configuration configuration;
    private int[] imageSizes;


    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
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

}