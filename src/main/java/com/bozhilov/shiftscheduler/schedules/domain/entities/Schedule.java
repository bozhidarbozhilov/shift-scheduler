package com.bozhilov.shiftscheduler.schedules.domain.entities;
import java.util.*;
import com.bozhilov.shiftscheduler.common.models.BaseEntity;
import com.bozhilov.shiftscheduler.users.domain.entities.User;
import jakarta.persistence.*;

@Entity
@Table(name="schedules")
public class Schedule extends BaseEntity {
    private List<Day> days;
    private User user;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name="schedules_days",
    joinColumns = @JoinColumn(name="schedule_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="day_id", referencedColumnName = "id"))
    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }


}
