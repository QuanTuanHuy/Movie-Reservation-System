package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.BaseEntity;
import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.GetStatisticRequest;
import hust.project.moviereservationsystem.entity.response.StatisticResponse;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.ICinemaHallPort;
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

    public StatisticResponse getStatistic(GetStatisticRequest request) {
        List<Long> cinemaHallIds = new ArrayList<>();
        if (request.getCinemaId() != null) {
            cinemaHallIds = cinemaHallPort.getCinemaHallsByCinemaId(request.getCinemaId())
                    .stream()
                    .map(BaseEntity::getId)
                    .toList();
        }

        List<ShowEntity> shows = showPort.getShowsForStatistic(request, cinemaHallIds);
        List<Long> showIds = shows.stream().map(ShowEntity::getId).toList();

        List<BookingEntity> bookings = bookingPort.getBookingsByShowIds(showIds);

        Long revenue = 0L, totalTickets = 0L;

        for (var booking : bookings) {
            revenue += booking.getTotalPrice();
            totalTickets += booking.getTotalSeats();
        }

        return new StatisticResponse(revenue, totalTickets);
    }
}
