package com.bozhilov.shiftscheduler.schedules.services.models;

import com.bozhilov.shiftscheduler.schedules.domain.entities.Day;

import java.util.List;

public class ScheduleServiceModel {
    List<Day> days;

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
