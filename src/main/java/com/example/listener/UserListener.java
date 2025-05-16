package com.example.listener;

import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserListener {
    private final UserRepository repository;

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void listen(User user) {
        user.setEnrichedField("Enriched: " + user.getEmail());
        repository.save(user);
    }
}
