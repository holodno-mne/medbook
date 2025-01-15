package com.exp.self.medbook.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Configuration
public class CustomSecurityContext {

    private String preferredUsername;

    private UUID uuid;

    private String email;

    private String keycloakToken;

    private String role;

    private List<String> permissions;

    private String identityProvider;
}
