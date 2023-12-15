package com.bozhilov.shiftscheduler.schedules.web.models;

public class ScheduleCreateViewModel {
    private int dayShiftsNum;
    private int nightShiftsNum;
    private int daysOffNum;
    private String startDate;
    private String endDate;
    private String dayStatus;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String date) {
        this.startDate = date;
    }

    public String getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(String status) {
        this.dayStatus = status;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
