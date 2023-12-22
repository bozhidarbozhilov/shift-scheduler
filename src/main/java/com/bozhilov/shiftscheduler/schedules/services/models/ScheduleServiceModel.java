package com.bozhilov.shiftscheduler.schedules.services.models;

import java.util.List;


public class ScheduleServiceModel {
    List<DayServiceModel> days;

    public List<DayServiceModel> getDays() {
        return days;
    }

    public void setDays(List<DayServiceModel> days) {
        this.days = days;
    }
}
