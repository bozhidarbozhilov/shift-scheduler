package com.bozhilov.shiftscheduler.schedules.web.models;

import com.bozhilov.shiftscheduler.schedules.domain.entities.Day;
import com.bozhilov.shiftscheduler.schedules.services.models.DayServiceModel;
import com.fasterxml.jackson.datatype.jsr310.deser.MonthDayDeserializer;

import java.util.List;

public class ScheduleViewModel {
    private String name;

    List<DayServiceModel> days;

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
