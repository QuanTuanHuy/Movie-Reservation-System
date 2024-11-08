package hust.project.moviereservationsystem.repository.httpClient;

import hust.project.moviereservationsystem.config.FeignClientConfig;
import hust.project.moviereservationsystem.entity.request.EmailRequest;
import hust.project.moviereservationsystem.entity.response.SendEmailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "email-service", url = "${notification.email.brevo-url}",
        configuration = { FeignClientConfig.class })
public interface EmailClient {
    @PostMapping(value = "/v3/smtp/email", produces = MediaType.APPLICATION_JSON_VALUE)
    SendEmailResponse sendEmail(@RequestHeader("api-key") String apiKey, @RequestBody EmailRequest body);
}
