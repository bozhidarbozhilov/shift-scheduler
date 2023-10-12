package com.bozhilov.shiftscheduler.services.models;

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
