package com.bozhilov.shiftscheduler.schedules.services.implementations;

import com.bozhilov.shiftscheduler.schedules.domain.entities.Schedule;
import com.bozhilov.shiftscheduler.schedules.repositories.ScheduleRepository;
import com.bozhilov.shiftscheduler.schedules.services.models.DayServiceModel;
import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.bozhilov.shiftscheduler.schedules.services.contracts.ScheduleService;
import com.bozhilov.shiftscheduler.schedules.web.models.ScheduleCreateViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private static final String DAY_SHIFT = "DAY";
    private static final String NIGHT_SHIFT = "NGHT";
    private static final String DAY_OFF = "OFF";
    private final ModelMapper mapper;
    private final ScheduleRepository repository;

    @Autowired
    public ScheduleServiceImpl(ModelMapper mapper, ScheduleRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ScheduleServiceModel saveSchedule(ScheduleServiceModel scheduleServiceModel) {
        Schedule schedule = mapper.map(scheduleServiceModel, Schedule.class);
        Schedule savedSchedule = repository.save(schedule);
        return mapper.map(savedSchedule, ScheduleServiceModel.class);
    }

    @Override
    public ScheduleServiceModel generateSchedule(ScheduleCreateViewModel scheduleCreateViewModel) {

        String startDateStr = scheduleCreateViewModel.getStartDate();
        String endDateStr = scheduleCreateViewModel.getEndDate();
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        Period timeInterval = Period.between(startDate, endDate);
        int interval = timeInterval.getDays() + 1;
        int daysShiftsNumber = scheduleCreateViewModel.getDayShiftsNum();
        int nightsShiftsNumber = scheduleCreateViewModel.getNightShiftsNum();
        int daysOffNumber = scheduleCreateViewModel.getDaysOffNum();
        int step = daysShiftsNumber + nightsShiftsNumber + daysOffNumber;

        List<DayServiceModel> days = new ArrayList<>();
        for (int i = 0; i < interval; i = i + step) {
            LocalDate currentDate = startDate.plusDays(i);
            days.addAll(generateScheduleCycle(currentDate, endDate, daysShiftsNumber, nightsShiftsNumber, daysOffNumber));
        }
        ScheduleServiceModel scheduleServiceModel = new ScheduleServiceModel();
        scheduleServiceModel.setDays(days);
        scheduleServiceModel.setName(scheduleCreateViewModel.getName());
        return scheduleServiceModel;
    }

    private List<DayServiceModel> generateScheduleCycle(LocalDate date,LocalDate endDate, int daysShiftsNumber, int nightsShiftsNumber, int daysOffNumber){
        int step = daysShiftsNumber + nightsShiftsNumber + daysOffNumber;
        List<DayServiceModel> cycle = new ArrayList<>(step);
        for (int i = 0; i < step; i++) {
            DayServiceModel currentDay = new DayServiceModel();
            if(i<daysShiftsNumber){
                currentDay.setStatus(DAY_SHIFT);
            }else if(i < daysShiftsNumber + nightsShiftsNumber){
                currentDay.setStatus(NIGHT_SHIFT);
            }else{
                currentDay.setStatus(DAY_OFF);
            }
            LocalDate nextDay = date.plusDays(i);
            if(nextDay.isAfter(endDate)){
                break;
            }
            currentDay.setDate(nextDay);
            cycle.add(currentDay);
        }
        return cycle;
    }

    @Override
    public List<ScheduleServiceModel> allSchedules() {
        List<ScheduleServiceModel> allSchedules = repository
                .findAll().stream().map(schedule -> mapper.map(schedule, ScheduleServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
        return allSchedules;
    }
}
