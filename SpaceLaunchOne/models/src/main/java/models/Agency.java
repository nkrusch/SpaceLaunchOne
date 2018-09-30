package models;


import models.base.InfoObj;

@SuppressWarnings("SpellCheckingInspection")
public class Agency extends InfoObj {

    private String countryCode;
    private String abbrev;
    private int islsp;
    private int type;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean getIslsp() {
        return islsp == 1;
    }

    public void setIslsp(int islsp) {
        this.islsp = islsp;
    }

}
