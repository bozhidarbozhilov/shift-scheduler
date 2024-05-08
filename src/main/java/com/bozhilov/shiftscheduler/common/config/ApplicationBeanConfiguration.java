package com.bozhilov.shiftscheduler.common.config;

import com.bozhilov.shiftscheduler.schedules.config.Status;
import com.bozhilov.shiftscheduler.schedules.domain.entities.Day;
import com.bozhilov.shiftscheduler.schedules.domain.entities.Schedule;
import com.bozhilov.shiftscheduler.schedules.services.models.DayServiceModel;
import com.bozhilov.shiftscheduler.schedules.services.models.ScheduleServiceModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        // DayServiceModel to Day mappings
        Converter<String, LocalDate> localDateConverter = ctx -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(ctx.getSource(), dateTimeFormatter);
            return date;
        };

//        Converter<String, LocalDate> dayDateConverter = new AbstractConverter<String, LocalDate>() {
//            @Override
//            protected LocalDate convert(String s) {
//                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate date = LocalDate.parse(s, dateTimeFormatter);
//                return date;
//            }
//        };

        Converter<String, Status> statusConverter = ctx -> Status.valueOf(ctx.getSource());
        modelMapper.typeMap(DayServiceModel.class, Day.class)
                   .addMappings(mapper->mapper.using(localDateConverter)
                                             .map(DayServiceModel::getDate, Day::setDate))
                   .addMappings(mapper->mapper.using(statusConverter)
                                   .map(DayServiceModel::getStatus, Day::setStatus));

        //ScheduleServiceModel to Schedule mappings
        modelMapper.typeMap(ScheduleServiceModel.class, Schedule.class)
                .addMapping(ScheduleServiceModel::getDays,Schedule::setDays);

        return modelMapper;
    }

    @Bean
    public Gson gson(){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        return gson;
    }

}
