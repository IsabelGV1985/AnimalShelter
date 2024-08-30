package com.example.AnimalShelter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->auth.requestMatchers(publicEndpoints()).permitAll()
                    .anyRequest().authenticated())

                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .cors(cors -> cors.configurationSource(corsConfigurationSource())); // llama a Configura CORS;
        return httpSecurity.build();
    }

    private RequestMatcher publicEndpoints(){
        return new OrRequestMatcher(
            new AntPathRequestMatcher("/api/auth/**")
            /* 
            .requestMatchers(GET,"/api/v1/donations/**").hasAnyRole(ADMIN.name())
            .requestMatchers(GET, "/api/v1/news/**").hasAnyAuthority(ADMIN_READ.name())
            */  
        );
    }
    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.addAllowedOrigin("http://localhost:3000"); // CORS configuration
            config.addAllowedHeader("*");
            config.addAllowedMethod("*"); // Permitir todos los métodos
            source.registerCorsConfiguration("/**", config);
            return source;
}

}


