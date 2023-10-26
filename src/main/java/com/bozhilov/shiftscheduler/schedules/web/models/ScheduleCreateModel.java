package com.bozhilov.shiftscheduler.schedules.web.models;

import com.bozhilov.shiftscheduler.schedules.domain.entities.Day;

import java.time.LocalDate;

public class ScheduleCreateModel {
    LocalDate startDate;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
