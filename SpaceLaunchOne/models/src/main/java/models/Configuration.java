package models;

import com.google.gson.annotations.SerializedName;

import models.base.BaseObj;

public class Configuration extends BaseObj {

    private String family;
    @SerializedName("full_name")
    private String fullName;
    private String variant;
    private String url;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
