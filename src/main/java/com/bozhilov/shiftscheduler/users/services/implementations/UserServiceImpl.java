package com.bozhilov.shiftscheduler.users.services.implementations;

import com.bozhilov.shiftscheduler.users.domain.entities.User;
import com.bozhilov.shiftscheduler.users.repositories.UserRepository;
import com.bozhilov.shiftscheduler.users.services.models.UserServiceModel;
import com.bozhilov.shiftscheduler.users.services.services.UserService;
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
