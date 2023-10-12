package com.bozhilov.shiftscheduler.web.controllers;

import com.bozhilov.shiftscheduler.data.models.BaseModel;
import com.bozhilov.shiftscheduler.web.annotations.PageTitle;
import com.bozhilov.shiftscheduler.web.models.user.RegisterUserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @GetMapping("/register")
    @PageTitle("User Register")
    public ModelAndView getRegisterPage(@ModelAttribute(name="registerUser") RegisterUserModel registerUserModel, ModelAndView modelAndView){
        modelAndView.setViewName(super.view("user/register"));
        return modelAndView;
    }
}
