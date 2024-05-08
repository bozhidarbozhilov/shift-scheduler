package com.bozhilov.shiftscheduler.schedules.web.models;

import java.time.LocalDate;

public class ScheduleCreateModel {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private int dayShiftsNum;
    private int nightShiftsNum;
    private int daysOffNum;
    private String status;

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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getDayShiftsNum() {
        return dayShiftsNum;
    }

    public void setDayShiftsNum(int dayShiftsNum) {
        this.dayShiftsNum = dayShiftsNum;
    }

    public int getNightShiftsNum() {
        return nightShiftsNum;
    }

    public void setNightShiftsNum(int nightShiftsNum) {
        this.nightShiftsNum = nightShiftsNum;
    }

    public int getDaysOffNum() {
        return daysOffNum;
    }

    public void setDaysOffNum(int daysOffNum) {
        this.daysOffNum = daysOffNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
