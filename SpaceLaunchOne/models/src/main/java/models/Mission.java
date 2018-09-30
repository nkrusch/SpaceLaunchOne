package models;

import models.base.InfoObj;

public class Mission extends InfoObj {

    private String description;
    private Payload[] payloads;
    private Agency[] agencies;
    private MissionEvent[] events;
    private String typeName;
    private int launch;
    private int type;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLaunch() {
        return launch;
    }

    public void setLaunch(int launch) {
        this.launch = launch;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Agency[] getAgencies() {
        return agencies;
    }

    public void setAgencies(Agency[] agencies) {
        this.agencies = agencies;
    }

    public MissionEvent[] getEvents() {
        return events;
    }

    public void setEvents(MissionEvent[] events) {
        this.events = events;
    }

    public Payload[] getPayloads() {
        return payloads;
    }

    public void setPayloads(Payload[] payloads) {
        this.payloads = payloads;
    }

}
