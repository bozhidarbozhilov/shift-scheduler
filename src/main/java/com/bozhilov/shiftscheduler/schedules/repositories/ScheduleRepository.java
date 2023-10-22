package com.bozhilov.shiftscheduler.schedules.repositories;

import com.bozhilov.shiftscheduler.schedules.domain.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}
