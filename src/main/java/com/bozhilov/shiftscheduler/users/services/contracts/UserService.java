package com.bozhilov.shiftscheduler.users.services.contracts;

import com.bozhilov.shiftscheduler.users.services.models.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);
}
