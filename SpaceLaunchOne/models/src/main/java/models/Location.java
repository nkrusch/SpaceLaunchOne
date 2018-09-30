package models;

import models.base.InfoObj;

@SuppressWarnings("SpellCheckingInspection")
public class Location extends InfoObj {

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

    public Pad getPad() {
        if (pads != null && pads.length > 0)
            return pads[0];
        return null;
    }
}
