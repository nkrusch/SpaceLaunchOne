package models;

import models.base.BaseObj;

public class RocketFamily extends BaseObj {

    private Agency[] agencies;

    public Agency[] getAgencies() {
        return agencies;
    }

    public void setAgencies(Agency[] agencies) {
        this.agencies = agencies;
    }
}
