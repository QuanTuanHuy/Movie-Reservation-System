package hust.project.moviereservationsystem.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.util.Pair;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "app.security.filter")
public class RequestFilter {
    List<Pair<String, String>> publicUrls;

    List<ProtectedUrl> protectedUrls;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProtectedUrl {
        private String urlPattern;
        private List<String> roles;
    }
}
