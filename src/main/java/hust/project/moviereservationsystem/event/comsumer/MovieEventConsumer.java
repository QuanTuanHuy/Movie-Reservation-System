package hust.project.moviereservationsystem.event.comsumer;

import hust.project.moviereservationsystem.constant.EmailTemplate;
import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.entity.request.RecipientEMail;
import hust.project.moviereservationsystem.entity.request.SendEmailRequest;
import hust.project.moviereservationsystem.event.dto.MovieCreatedEvent;
import hust.project.moviereservationsystem.port.IUserPort;
import hust.project.moviereservationsystem.service.IEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class MovieEventConsumer {
    private final IUserPort userPort;
    private final IEmailService emailService;

    @KafkaListener(topics = "new_movie_created", groupId = "movie_group")
    public void listenMovieCreatedEvent(MovieCreatedEvent event) {
        System.out.println("Received message: " + event);

        Map<String, String> params = new HashMap<>();
        params.put("title", event.getTitle());
        params.put("description", event.getDescription());
        params.put("releaseDate", event.getReleaseDate());
        params.put("movieInfoUrl", event.getMovieInfoUrl());

        List<UserEntity> users = userPort.getAllUsers();
        users.forEach(user -> {
            SendEmailRequest request = SendEmailRequest.builder()
                    .to(RecipientEMail.builder()
                            .name(user.getFirstName() + " " + user.getLastName())
                            .email(user.getEmail())
                            .build())
                    .subject("We have a new movie for you")
                    .htmlContent(EmailTemplate.MOVIE_CREATED_TEMPLATE)
                    .params(params)
                    .build();

            emailService.sendEmail(request);
        });
    }
}
