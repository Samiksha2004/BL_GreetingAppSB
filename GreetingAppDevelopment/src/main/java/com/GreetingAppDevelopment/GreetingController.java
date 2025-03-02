package com.GreetingAppDevelopment;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Map<String, String> getGreeting() {
        return Map.of("message", "Hello from GET!");
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        return Map.of("message", "Hello from POST!", "received", request.toString());
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        return Map.of("message", "Hello from PUT!", "updated", request.toString());
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello from DELETE!");
    }
}
