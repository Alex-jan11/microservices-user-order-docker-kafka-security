// config/AuditConfig.java
package com.example.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig {
    @Bean(name = "auditorProvider")
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("system"); // înlocuiește cu utilizatorul real mai târziu
    }
}
