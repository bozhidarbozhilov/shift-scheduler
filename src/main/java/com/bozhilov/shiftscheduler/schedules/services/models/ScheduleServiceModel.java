package com.bozhilov.shiftscheduler.schedules.services.models;

import java.util.List;


public class ScheduleServiceModel {
    private String name;
    private List<DayServiceModel> days;

    public List<DayServiceModel> getDays() {
        return days;
    }

    public void setDays(List<DayServiceModel> days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
