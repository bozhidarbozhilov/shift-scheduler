package com.bozhilov.shiftscheduler.schedules.services.implementations;

import com.bozhilov.shiftscheduler.schedules.config.Status;
import com.bozhilov.shiftscheduler.schedules.domain.entities.Day;
import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.bozhilov.shiftscheduler.schedules.services.contracts.ScheduleService;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateModel;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateViewModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public ScheduleServiceModel saveSchedule(ScheduleServiceModel scheduleServiceModel) {
        return null;
    }

    @Override
    public ScheduleServiceModel generateSchedule(ScheduleCreateViewModel scheduleCreateViewModel) {

        String startDateStr = scheduleCreateViewModel.getStartDate();
        String endDateStr = scheduleCreateViewModel.getEndDate();
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        Period timeInterval = Period.between(startDate, endDate);
        int interval = timeInterval.getDays();
        int daysShiftsNumber = scheduleCreateViewModel.getDayShiftsNum();
        int nightsShiftsNumber = scheduleCreateViewModel.getNightShiftsNum();
        int daysOffNumber = scheduleCreateViewModel.getDaysOffNum();
        int step = daysShiftsNumber + nightsShiftsNumber + daysOffNumber;

        List<Day> days = new ArrayList<>();
        for (int i = 0; i < interval; i = i + step) {
            days.addAll(generateScheduleCycle(startDate.plusDays(i), daysShiftsNumber, nightsShiftsNumber, daysOffNumber));
        }
        ScheduleServiceModel scheduleServiceModel = new ScheduleServiceModel();
        scheduleServiceModel.setDays(days);
        return scheduleServiceModel;
    }

    private List<Day> generateScheduleCycle(LocalDate date, int daysShiftsNumber, int nightsShiftsNumber, int daysOffNumber){
        int step = daysShiftsNumber + nightsShiftsNumber + daysOffNumber;
        List<Day> cycle = new ArrayList<>(step);
        for (int i = 0; i < step; i++) {
            Day currentDay = new Day();
            if(i<daysShiftsNumber){
                currentDay.setStatus(Status.DAY);
            }else if(i < daysShiftsNumber + nightsShiftsNumber){
                currentDay.setStatus(Status.NGHT);
            }else{
                currentDay.setStatus(Status.OFF);
            }
            currentDay.setDate(date.plusDays(i));
            cycle.add(currentDay);
        }
        return cycle;
    }
}
