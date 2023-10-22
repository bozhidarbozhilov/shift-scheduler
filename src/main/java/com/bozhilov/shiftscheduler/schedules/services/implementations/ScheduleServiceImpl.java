package com.bozhilov.shiftscheduler.schedules.services.implementations;

import com.bozhilov.shiftscheduler.schedules.config.Status;
import com.bozhilov.shiftscheduler.schedules.domain.entities.Day;
import com.bozhilov.shiftscheduler.schedules.services.models.DayServiceModel;
import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.bozhilov.shiftscheduler.schedules.services.services.ScheduleService;
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
    public ScheduleServiceModel generateSchedule() {
        List<Day> days = new ArrayList<>();

        LocalDate startDate = LocalDate.of(2023, 10, 1);
        LocalDate endDate = LocalDate.of(2023,10, 31);
        Period timeInterval = Period.between(startDate, endDate);
        int interval = timeInterval.getDays();
        int daysShiftsNumber = 2;
        int nightsShiftsNumber = 2;
        int daysOffNumber = 4;
        int step = daysShiftsNumber + nightsShiftsNumber + daysOffNumber;
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
