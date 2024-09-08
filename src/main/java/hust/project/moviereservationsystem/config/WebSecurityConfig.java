package hust.project.moviereservationsystem.config;

import hust.project.moviereservationsystem.property.RequestFilter;
import hust.project.moviereservationsystem.security.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final RequestFilter requestFilter;
    private final JwtTokenFilter jwtTokenFilter;

    private String[] publicUrls = {
            "/api/v1/cinemas/{cinema_id}/shows"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(publicUrls).permitAll();
                    requestFilter.getPublicUrls().forEach(url -> {
                        if (url.getFirst().contains("\\")) {
                            authorize.requestMatchers(RegexRequestMatcher.regexMatcher(
                                    HttpMethod.valueOf(url.getSecond()), url.getFirst())).permitAll();
                        } else {
                            authorize.requestMatchers(url.getFirst()).permitAll();
                        }
                    });

                    requestFilter.getProtectedUrls().forEach(url -> {
                        authorize.requestMatchers(url.getUrlPattern()).hasAnyRole(url.getRoles().toArray(new String[0]));
                    });

                    authorize.anyRequest().authenticated();
                });

        return http.build();
    }
}
