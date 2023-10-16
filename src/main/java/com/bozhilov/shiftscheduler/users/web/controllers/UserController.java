package com.bozhilov.shiftscheduler.users.web.controllers;

import com.bozhilov.shiftscheduler.common.controllers.BaseController;
import com.bozhilov.shiftscheduler.users.services.models.UserServiceModel;
import com.bozhilov.shiftscheduler.users.services.services.UserService;
import com.bozhilov.shiftscheduler.common.annotations.PageTitle;
import com.bozhilov.shiftscheduler.users.web.models.user.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private UserService userService;
    private ModelMapper mapper;
    @Autowired
    public UserController(UserService userService, ModelMapper mapper){
        this.userService = userService;
        this.mapper = mapper;
    }
    @GetMapping("/register")
    @PageTitle("User Register")
    public ModelAndView getRegisterPage(@ModelAttribute(name="registerUser") RegisterUserModel registerUserModel, ModelAndView modelAndView){
        modelAndView.setViewName(super.view("user/register"));
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute(name="registerUser") RegisterUserModel registerUserModel,
                                     ModelAndView modelAndView){
        UserServiceModel userServiceModel = mapper.map(registerUserModel, UserServiceModel.class);
        userService.registerUser(userServiceModel);
        modelAndView.setViewName(super.redirect("home"));
        return modelAndView;
    }
}
