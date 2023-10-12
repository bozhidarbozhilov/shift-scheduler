package com.bozhilov.shiftscheduler.services.services;

import com.bozhilov.shiftscheduler.services.models.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);
}
