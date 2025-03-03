package com.example.GreetinngAppDevelopment.controller;

import com.example.GreetinngAppDevelopment.model.Greeting;
import com.example.GreetinngAppDevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;


    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> request) {
        Greeting updatedGreeting = greetingService.updateGreeting(id, request.get("message"));
        return ResponseEntity.ok(updatedGreeting);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        try {
            greetingService.deleteGreeting(id);
            return ResponseEntity.ok("Greeting deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}