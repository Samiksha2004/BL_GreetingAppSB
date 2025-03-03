package com.GreetingApp.controller;

import com.GreetingApp.model.Greeting;
import com.GreetingApp.repository.GreetingRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
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
//    @GetMapping("/{id}")
//    public Greeting getGreetingById(@PathVariable Long id) {
//        return greetingRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        return greeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
