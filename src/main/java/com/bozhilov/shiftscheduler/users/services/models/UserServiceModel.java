package com.bozhilov.shiftscheduler.users.services.models;

import com.bozhilov.shiftscheduler.common.models.BaseServiceModel;

public class UserServiceModel extends BaseServiceModel {
    private String username;
    private String password;

    public UserServiceModel(){}
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
