package com.ceyentra.applab.controller;

import com.ceyentra.applab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/main") //api path name karaddi mehema danna /api/v1/basdasd
public class MainController {


    @GetMapping
    public String securedEndpoint() {
        return "hello";
    }
}
