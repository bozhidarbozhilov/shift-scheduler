package com.bozhilov.shiftscheduler.schedules.domain.entities;

import com.bozhilov.shiftscheduler.common.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="days")
public class Day extends BaseEntity {
}
