package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.GetBookingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.IShowPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetBookingUserCase {
    private final IBookingPort bookingPort;
    private final IShowPort showPort;

    public Pair<PageInfo, List<BookingEntity>> getAllBookings(GetBookingRequest filter) {
        return bookingPort.getAllBookings(filter);
    }

    public List<BookingEntity> getBookingsByUserId(Long userId) {
        List<BookingEntity> bookings = bookingPort.getBookingsByUserId(userId);

        var showIds = bookings.stream().map(BookingEntity::getShowId).toList();
        var shows = showPort.getShowsByIds(showIds);
        var mapIdToShow = shows.stream().collect(Collectors.toMap(ShowEntity::getId, Function.identity()));

        return bookings.stream().peek(booking -> {
            booking.setShow(mapIdToShow.get(booking.getShowId()));
        }).toList();
    }
}
