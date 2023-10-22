package com.bozhilov.shiftscheduler.schedules.web;

import com.bozhilov.shiftscheduler.schedules.services.services.ScheduleService;
import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    private ScheduleService scheduleService;
    private Gson gson;
    @Autowired
    public ScheduleController(ScheduleService scheduleService, Gson gson) {
        this.scheduleService = scheduleService;
        this.gson = gson;
    }

    @GetMapping(value = "/generate", produces = "application/json")
    @ResponseBody
    public String generateSchedule(){
        ScheduleServiceModel scheduleServiceModel = scheduleService.generateSchedule();
        var json = gson.toJson(scheduleServiceModel.getDays());
        return json;
    }
}
