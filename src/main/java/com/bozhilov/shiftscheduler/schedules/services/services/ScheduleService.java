package com.bozhilov.shiftscheduler.schedules.services.services;


import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;

public interface ScheduleService {
    ScheduleServiceModel saveSchedule(ScheduleServiceModel scheduleServiceModel);
    ScheduleServiceModel generateSchedule();
}
