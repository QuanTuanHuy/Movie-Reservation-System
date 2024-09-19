package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.request.GetBookingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IBookingPort {
    BookingEntity save(BookingEntity bookingEntity);

    Pair<PageInfo, List<BookingEntity>> getAllBookings(GetBookingRequest filter);

    BookingEntity getBookingById(Long id);

    BookingEntity getBookingByPaymentId(Long paymentId);

    List<BookingEntity> getBookingsByUserId(Long userId);

    List<BookingEntity> getBookingsByShowIds(List<Long> showIds);
}
