package com.GreetingAppDevelopment.controller;
import com.GreetingAppDevelopment.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting/v2")
public class GreetingController2 {
    private final GreetingService greetingService;

    @Autowired
    public GreetingController2(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return greetingService.getGreetingMessage();
    }
}
