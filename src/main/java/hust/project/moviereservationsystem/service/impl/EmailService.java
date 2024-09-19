package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.request.EmailRequest;
import hust.project.moviereservationsystem.entity.request.SendEmailRequest;
import hust.project.moviereservationsystem.entity.request.SenderEmail;
import hust.project.moviereservationsystem.entity.response.SendEmailResponse;
import hust.project.moviereservationsystem.exception.SendEmailException;
import hust.project.moviereservationsystem.repository.httpClient.EmailClient;
import hust.project.moviereservationsystem.service.IEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {
    private final EmailClient emailClient;

    @Value("${notification.email.api-key}")
    private String apiKey;

    @Override
    public SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(SenderEmail.builder()
                        .email("hochoanap2004@gmail.com")
                        .name("Huy Cinema")
                        .build())
                .to(List.of(sendEmailRequest.getTo()))
                .subject(sendEmailRequest.getSubject())
                .htmlContent(sendEmailRequest.getHtmlContent())
                .params(sendEmailRequest.getParams())
                .build();

        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        } catch (Exception e) {
            throw new SendEmailException();
        }
    }
}
