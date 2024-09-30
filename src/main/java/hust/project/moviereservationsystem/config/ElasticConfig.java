package hust.project.moviereservationsystem.config;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticConfig extends ElasticsearchConfiguration {

    @Value("${spring.data.elasticsearch.rest.url}")
    private String url;

    @Value("${spring.data.elasticsearch.rest.username}")
    private String username;

    @Value("${spring.data.elasticsearch.rest.password}")
    private String password;

    @Override
    @NonNull
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(url)
                .withBasicAuth(username, password)
                .build();
    }
}
