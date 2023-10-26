package com.bozhilov.shiftscheduler.schedules.web.controllers;

import com.bozhilov.shiftscheduler.common.controllers.BaseController;
import com.bozhilov.shiftscheduler.schedules.services.services.ScheduleService;
import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateViewModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController {
    private ScheduleService scheduleService;
    private Gson gson;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, Gson gson) {
        this.scheduleService = scheduleService;
        this.gson = gson;
    }

    @GetMapping("/create")
    public ModelAndView getCreateSchedule(@ModelAttribute(name="scheduleCreateViewModel") ScheduleCreateViewModel scheduleCreateViewModel,
                                          ModelAndView modelAndView) {
        modelAndView.setViewName(super.view("schedule-create"));
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createSchedule(@ModelAttribute(name="scheduleCreateViewModel") ScheduleCreateViewModel scheduleCreateViewModel,
                                       ModelAndView modelAndView) {
        String date = scheduleCreateViewModel.getDate();
        ScheduleCreateModel scheduleCreateModel = new ScheduleCreateModel();
        //scheduleCreateModel.setStartDate(startDate);
        scheduleCreateModel.setStatus(scheduleCreateViewModel.getDayStatus());
        modelAndView.setViewName(super.redirect("calendar"));
        return modelAndView;
    }

    @GetMapping(value = "/generate", produces = "application/json")
    @ResponseBody
    public ModelAndView getCalendar(ModelAndView modelAndView) {
        ScheduleServiceModel scheduleServiceModel = scheduleService.generateSchedule();
        modelAndView.setViewName(super.view("calendar"));
        return modelAndView;
    }

    @GetMapping(value = "/api/generate", produces = "application/json")
    @ResponseBody
    public String generateSchedule() {
        ScheduleServiceModel scheduleServiceModel = scheduleService.generateSchedule();
        var json = gson.toJson(scheduleServiceModel.getDays());
        return json;
    }

}
