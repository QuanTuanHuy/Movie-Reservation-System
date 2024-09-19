package hust.project.moviereservationsystem.event.comsumer;

import hust.project.moviereservationsystem.constant.EmailTemplate;
import hust.project.moviereservationsystem.constant.PaymentStatus;
import hust.project.moviereservationsystem.entity.*;
import hust.project.moviereservationsystem.entity.request.RecipientEMail;
import hust.project.moviereservationsystem.entity.request.SendEmailRequest;
import hust.project.moviereservationsystem.event.dto.PaymentEvent;
import hust.project.moviereservationsystem.port.*;
import hust.project.moviereservationsystem.service.IEmailService;
import hust.project.moviereservationsystem.usecase.GetShowUseCase;
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
public class PaymentEventConsumer {
    private final IBookingPort bookingPort;
    private final ICinemaPort cinemaPort;
    private final IUserPort userPort;
    private final IShowSeatPort showSeatPort;
    private final ICinemaHallSeatPort cinemaHallSeatPort;
    private final GetShowUseCase getShowUseCase;

    private final IEmailService emailService;


    @KafkaListener(topics = "payment_event", groupId = "payment_group")
    public void listenPaymentEvent(PaymentEvent event) {
        System.out.println("Received message: " + event);

        Map<String, String> params = new HashMap<>();

        if (event.getStatus().equals(PaymentStatus.COMPLETED.name())) {
            BookingEntity booking = bookingPort.getBookingByPaymentId(event.getPaymentId());
            UserEntity user = userPort.getUserById(booking.getUserId());
            ShowEntity show = getShowUseCase.getDetailShow(booking.getShowId());
            CinemaEntity cinema = cinemaPort.getCinemaById(show.getCinemaHall().getCinemaId());
            List<ShowSeatEntity> showSeats = showSeatPort.getShowSeatsByBookingId(booking.getId());
            List<CinemaHallSeatEntity> cinemaHallSeats = cinemaHallSeatPort.getByIds(
                    showSeats.stream().map(ShowSeatEntity::getCinemaHallSeatId).toList()
            );

            params.put("userFullName", user.getFirstName() + " " + user.getLastName());
            params.put("movieTitle", show.getMovie().getTitle());
            params.put("cinemaName", cinema.getName());
            params.put("cinemaHallName", show.getCinemaHall().getName());
            params.put("showTime", show.getStartTime().toString());
            params.put("showSeatCodes", cinemaHallSeats.stream().map(CinemaHallSeatEntity::getCode).toList().toString());
            params.put("bookingId", booking.getId().toString());

            SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                    .to(RecipientEMail.builder()
                            .email(user.getEmail())
                            .name(user.getFirstName() + " " + user.getLastName())
                            .build())
                    .subject("Bạn đã đặt vé xem phim thành công")
                    .htmlContent(EmailTemplate.PAYMENT_COMPLETED_TEMPLATE)
                    .params(params)
                    .build();

            emailService.sendEmail(sendEmailRequest);
        }


    }
}
