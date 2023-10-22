package com.bozhilov.shiftscheduler.users.domain.entities;

import com.bozhilov.shiftscheduler.common.models.BaseEntity;
import com.bozhilov.shiftscheduler.schedules.domain.entities.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private Employee employee;

    private List<Schedule> schedules;



    @OneToOne(mappedBy = "user", targetEntity = Employee.class)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @OneToMany(mappedBy = "user", targetEntity = Schedule.class)
    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
