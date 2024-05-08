package com.bozhilov.shiftscheduler.schedules.services.models;

import java.time.LocalDate;

public class DayServiceModel {
    private LocalDate date;
    private String status;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate localDate) {
        this.date = localDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
