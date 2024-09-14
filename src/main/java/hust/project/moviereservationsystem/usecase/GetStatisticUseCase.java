package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.constant.BookingStatus;
import hust.project.moviereservationsystem.entity.*;
import hust.project.moviereservationsystem.entity.request.GetStatisticRequest;
import hust.project.moviereservationsystem.entity.response.StatisticResponse;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.ICinemaHallPort;
import hust.project.moviereservationsystem.port.IPaymentPort;
import hust.project.moviereservationsystem.port.IShowPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStatisticUseCase {
    private final IShowPort showPort;
    private final ICinemaHallPort cinemaHallPort;
    private final IBookingPort bookingPort;
    private final IPaymentPort paymentPort;

    public StatisticResponse getStatistic(GetStatisticRequest request) {
        List<Long> cinemaHallIds = new ArrayList<>();
        if (request.getCinemaId() != null) {
            cinemaHallIds = cinemaHallPort.getCinemaHallsByCinemaId(request.getCinemaId())
                    .stream()
                    .map(CinemaHallEntity::getId)
                    .toList();
        }

        List<ShowEntity> shows = showPort.getShowsForStatistic(request, cinemaHallIds);
        List<Long> showIds = shows.stream().map(ShowEntity::getId).toList();

        List<BookingEntity> bookings = bookingPort.getBookingsByShowIds(showIds)
                .stream()
                .filter(booking -> booking.getStatus().equals(BookingStatus.COMPLETED.name()))
                .toList();

        List<PaymentEntity> payments = paymentPort.getPaymentsByBookingIds(
                bookings.stream().map(BookingEntity::getId).toList()
        );

        Long revenue = payments.stream().map(PaymentEntity::getFinalAmount).reduce(0L, Long::sum);
        Long totalTickets = bookings.stream().map(BookingEntity::getTotalSeats).reduce(0L, Long::sum);

        return new StatisticResponse(revenue, totalTickets);
    }
}
