package com.exp.self.medbook.config;

import com.exp.self.medbook.entity.Account;
import com.exp.self.medbook.entity.Permission;
import com.exp.self.medbook.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    @Value("${custom.keycloak.jwks.uri}")
    private String jwkUri;
    private final AccountRepository accountRepository;
    private final CustomSecurityContext customSecurityContext;
    private final CustomInternalSecretFilter customInternalSecretFilter;

    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/actuator/**"
    };

    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionAuthenticationStrategy(sessionAuthenticationStrategy())
                .and()
                .oauth2ResourceServer(resourceServerConfigurer -> resourceServerConfigurer
                        .jwt(jwtConfigurer -> jwtConfigurer
                                .jwtAuthenticationConverter(jwtAuthenticationConverter())))
                .addFilterAfter(customInternalSecretFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter());
        return jwtAuthenticationConverter;
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(jwkUri).build();
    }

    @Bean
    public Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter() {
        JwtGrantedAuthoritiesConverter delegate = new JwtGrantedAuthoritiesConverter();
        return new Converter<>() {
            @Override
            public Collection<GrantedAuthority> convert(Jwt jwt) {
                Collection<GrantedAuthority> grantedAuthorities = delegate.convert(jwt);
                Map<String, Object> claims = jwt.getClaims();
                String uuidString = claims.get("sub") != null ? (String) claims.get("sub") : "";
                UUID uuid = UUID.fromString(uuidString);
                customSecurityContext.setUuid(uuid);
                customSecurityContext.setPreferredUsername(jwt.getClaim("preferred_username"));
                customSecurityContext.setIdentityProvider(jwt.getClaim("identity_provider"));
                customSecurityContext.setEmail(claims.get("email") != null ? (String) claims.get("email") : "");
                customSecurityContext.setKeycloakToken(jwt.getTokenValue());
                Account existAccount = accountRepository.findByUuid(uuid).orElse(null);
                if (existAccount != null) {
                    customSecurityContext.setRole(existAccount.getRole().getSysname());
                    if (existAccount.getPermissions() != null && !existAccount.getPermissions().isEmpty()) {
                        customSecurityContext.setPermissions(new ArrayList<>());
                        for (Permission permission : existAccount.getPermissions()) {
                            customSecurityContext.getPermissions().add(permission.getSysname());
                            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getSysname()));
                        }
                    }
                }
                return grantedAuthorities;
            }
        };
    }
}
