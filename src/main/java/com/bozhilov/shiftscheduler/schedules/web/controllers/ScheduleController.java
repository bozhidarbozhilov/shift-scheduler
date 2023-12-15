package com.bozhilov.shiftscheduler.schedules.web.controllers;

import com.bozhilov.shiftscheduler.common.controllers.BaseController;
import com.bozhilov.shiftscheduler.schedules.services.contracts.ScheduleService;
import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateViewModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleViewModel;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController {
    private ScheduleService scheduleService;
    private ModelMapper mapper;
    private Gson gson;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, ModelMapper mapper, Gson gson) {
        this.scheduleService = scheduleService;
        this.mapper = mapper;
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
                                       ModelAndView modelAndView,
                                       RedirectAttributes redirectAttributes) {
        ScheduleServiceModel serviceModel = scheduleService.generateSchedule(scheduleCreateViewModel);
        ScheduleViewModel scheduleViewModel = mapper.map(serviceModel, ScheduleViewModel.class);
        redirectAttributes.addFlashAttribute("scheduleViewModel", scheduleViewModel);
        modelAndView.setViewName(super.redirect("schedule/generate"));
        //modelAndView.setViewName(super.redirect("schedule/generate"));
        return modelAndView;
    }

    @GetMapping(value = "/generate")
    public ModelAndView getCalendar(@ModelAttribute(name="scheduleViewModel") ScheduleViewModel scheduleViewModel, ModelAndView modelAndView) {
        modelAndView.addObject("scheduleViewModel", scheduleViewModel);
        modelAndView.setViewName(super.view("calendar"));
        return modelAndView;
    }

    @GetMapping(value = "/api/generate", produces = "application/json")
    @ResponseBody
    public String generateSchedule(@ModelAttribute(name="scheduleViewModel") ScheduleViewModel scheduleViewModel) {
        //ScheduleServiceModel scheduleServiceModel = scheduleService.generateSchedule();
        var json = gson.toJson(scheduleViewModel.getDays());
        return json;
    }

}
