package hust.project.moviereservationsystem.event.comsumer;

import hust.project.moviereservationsystem.event.dto.PaymentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentEventConsumer {

    @KafkaListener(topics = "payment_event", groupId = "payment_group")
    public void listenPaymentEvent(PaymentEvent event) {
        // movie title, cinema name, showtime, seat number, total price
        System.out.println("Received message: " + event);
    }
}
