package com.bozhilov.shiftscheduler.schedules.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappings {

    private ModelMapper mapper;
    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}
