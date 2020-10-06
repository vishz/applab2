package com.ceyentra.applab.controller;

import com.ceyentra.applab.dto.UserRegistrationDto;
import com.ceyentra.applab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String registerUserAccount(@RequestBody UserRegistrationDto registrationDto){

        userService.save(registrationDto);
        return "done"; // mehema string return karanna epa! json response ekak yawanna
     }
}
