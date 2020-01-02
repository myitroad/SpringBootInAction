package com.vash.boot_demo.controller;

import com.vash.boot_demo.entity.UserAgain;
import com.vash.boot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/query")
    @ResponseBody
    public List<UserAgain> getAllUsers() {
        return userService.getAllUsers();
    }


}
