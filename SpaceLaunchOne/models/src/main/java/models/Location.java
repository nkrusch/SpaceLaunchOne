package models;

import models.base.InfoObj;

@SuppressWarnings("SpellCheckingInspection")
public class Location extends InfoObj {

    private String countryCode;
    private String countrycode;
    private Pad[] pads;

    public Pad[] getPads() {
        return pads;
    }

    public void setPads(Pad[] pads) {
        this.pads = pads;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Pad getPad() {
        if (pads != null && pads.length > 0)
            return pads[0];
        return null;
    }
}
