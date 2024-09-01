package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.request.CreateBookingRequest;
import hust.project.moviereservationsystem.entity.request.GetBookingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IBookingService {
    BookingEntity createBooking(CreateBookingRequest request, Long userId);

    Pair<PageInfo, List<BookingEntity>> getAllBookings(GetBookingRequest filter);

    List<BookingEntity> getBookingsByUserId(Long userId);

    BookingEntity confirmBooking(Long bookingId);

    BookingEntity cancelBooking(Long bookingId, Long userId);
}
