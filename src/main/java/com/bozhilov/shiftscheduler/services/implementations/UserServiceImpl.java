package com.bozhilov.shiftscheduler.services.implementations;

import com.bozhilov.shiftscheduler.data.models.User;
import com.bozhilov.shiftscheduler.data.repositories.UserRepository;
import com.bozhilov.shiftscheduler.services.models.UserServiceModel;
import com.bozhilov.shiftscheduler.services.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper mapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {

        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = mapper.map(userServiceModel, User.class);
        User savedUser = userRepository.save(user);
        return mapper.map(savedUser, UserServiceModel.class);
    }
}
