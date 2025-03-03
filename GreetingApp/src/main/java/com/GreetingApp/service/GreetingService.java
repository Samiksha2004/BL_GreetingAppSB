package com.GreetingApp.service;

import com.GreetingApp.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final List<Greeting> greetings = new ArrayList<>();
    private long idCounter = 1;

    public Greeting saveGreeting(Greeting greeting) {
        greeting.setId(idCounter++);
        greetings.add(greeting);
        return greeting;
    }

    public List<Greeting> getAllGreetings() {
        return greetings;
    }

    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetings.stream()
                .filter(greeting -> greeting.getId().equals(id))
                .findFirst();

        if (existingGreeting.isPresent()) {
            existingGreeting.get().setMessage(newMessage);
            return existingGreeting.get();
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }
}
