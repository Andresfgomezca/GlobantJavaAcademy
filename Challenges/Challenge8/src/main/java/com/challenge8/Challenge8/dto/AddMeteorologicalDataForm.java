package com.challenge8.Challenge8.dto;

public class AddMeteorologicalDataForm {
    private int id;
    private String date;

    private int LocationId;
    public AddMeteorologicalDataForm(int id, String date, int locationId) {
        super();
        this.id=id;
        this.date=date;
        this.LocationId=locationId;
    }

    public AddMeteorologicalDataForm() {
    }

    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }
}

