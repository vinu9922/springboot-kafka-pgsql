package com.example.controller;

import com.example.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Api(tags = "User Management")
public class UserController {
    private final KafkaTemplate<String, User> kafkaTemplate;

    @PostMapping
    @ApiOperation("Publish user info to Kafka topic")
    public String publishUser(@RequestBody User user) {
        kafkaTemplate.send("user-topic", user);
        return "User published";
    }
}

