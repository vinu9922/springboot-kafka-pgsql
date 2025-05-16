package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

/// File: src/main/java/com/example/config/KafkaConfig.java
package com.example.config;

import com.example.model.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic userTopic() {
        return TopicBuilder.name("user-topic").partitions(1).replicas(1).build();
    }
}