package main.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Value("${token.key}")
    private String jwtSecret;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtDecoder jwtDecoder) throws Exception{
        http.
                csrf(token -> token.disable()).
                authorizeHttpRequests(request -> request
                        .requestMatchers("/write").hasRole("ROLE_USER")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth -> oauth
                        .jwt(Customizer.withDefaults()));

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder(){
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        SecretKey spec = Keys.hmacShaKeyFor(keyBytes);
        return NimbusJwtDecoder.withSecretKey(spec).build();
    }
}


