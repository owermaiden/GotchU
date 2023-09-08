package com.gotcha.main;

import com.gotcha.main.config.SecurityAuditorAware;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="auditorAware")
@EnableCaching
@OpenAPIDefinition
@SpringBootApplication
public class GotchUApplication {

    public static void main(String[] args) {
        SpringApplication.run(GotchUApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SecurityAuditorAware();
    }

}
