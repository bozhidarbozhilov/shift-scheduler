package com.bozhilov.shiftscheduler.schedules.services.contracts;

import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateViewModel;

public interface ScheduleService {
    ScheduleServiceModel saveSchedule(ScheduleServiceModel scheduleServiceModel);
    ScheduleServiceModel generateSchedule(ScheduleCreateViewModel scheduleCreateModel);
}
