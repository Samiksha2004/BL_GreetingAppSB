package com.GreetingApp.controller;

import com.GreetingApp.model.Greeting;
import com.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Create a new greeting (POST)
    @PostMapping
    public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting) {
        Greeting savedGreeting = greetingRepository.save(greeting);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGreeting);
    }

    // Get all greetings (GET)
    @GetMapping
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        List<Greeting> greetings = greetingRepository.findAll();
        return ResponseEntity.ok(greetings);
    }
}
