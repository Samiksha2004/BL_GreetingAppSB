package com.GreetingApp.controller;

import com.GreetingApp.model.Greeting;
import com.GreetingApp.repository.GreetingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingRepository greetingRepository;

    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @PostMapping
    public Greeting addGreeting(@RequestBody Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
