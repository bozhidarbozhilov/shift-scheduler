package com.bozhilov.shiftscheduler.schedules.services.models;

public class DayServiceModel {
    private String localDate;
    private String status;

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
