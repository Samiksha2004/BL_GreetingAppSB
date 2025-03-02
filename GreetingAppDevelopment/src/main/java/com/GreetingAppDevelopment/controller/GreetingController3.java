package com.GreetingAppDevelopment.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting/v3")
public class GreetingController3 {

    @GetMapping
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        // Condition 1: Both firstName & lastName provided
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "!";
        }
        // Condition 2: Only firstName provided
        else if (firstName != null) {
            return "Hello " + firstName + "!";
        }
        // Condition 3: Only lastName provided
        else if (lastName != null) {
            return "Hello " + lastName + "!";
        }
        // Condition 4: No name provided, return "Hello World"
        else {
            return "Hello World!";
        }
    }
}
