package com.bozhilov.shiftscheduler.schedules.domain.entities;

import com.bozhilov.shiftscheduler.common.models.BaseEntity;
import com.bozhilov.shiftscheduler.schedules.config.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="days")
public class Day extends BaseEntity {
    private LocalDate date;
    private Status status;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
