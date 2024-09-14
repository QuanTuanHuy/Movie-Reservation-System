package hust.project.moviereservationsystem.event.comsumer;

import hust.project.moviereservationsystem.event.dto.NotificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationEventConsumer {

    @KafkaListener(topics = "cinema_movie_notification", groupId = "cinema_movie_notification")
    public void listenNotificationEvent(NotificationEvent notificationEvent) {
        log.info("Received message: {}", notificationEvent);
    }
}
