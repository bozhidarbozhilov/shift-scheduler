package com.bozhilov.shiftscheduler.users.domain.entities;

import com.bozhilov.shiftscheduler.common.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private Employee employee;

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
}
