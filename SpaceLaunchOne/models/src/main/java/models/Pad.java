package models;

import models.base.InfoObj;

public class Pad extends InfoObj {

    private int padType;
    private Double latitude;
    private Double longitude;
    private String mapURL;
    private int retired;
    private int locationid;
    private Agency[] agencies;

    public int getPadType() {
        return padType;
    }

    public void setPadType(int padType) {
        this.padType = padType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMapURL() {
        return mapURL;
    }

    public void setMapURL(String mapURL) {
        this.mapURL = mapURL;
    }

    public int getRetired() {
        return retired;
    }

    public void setRetired(int retired) {
        this.retired = retired;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public Agency[] getAgencies() {
        return agencies;
    }

    public void setAgencies(Agency[] agencies) {
        this.agencies = agencies;
    }

}
