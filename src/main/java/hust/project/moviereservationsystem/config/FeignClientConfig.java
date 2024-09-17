package hust.project.moviereservationsystem.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(3000, 5000, 5);
    }
}
