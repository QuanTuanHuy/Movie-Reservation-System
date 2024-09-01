package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.constant.BookingStatus;
import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.exception.UpdateBookingException;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.IShowPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateBookingUseCase {
    private final IBookingPort bookingPort;
    private final IShowPort showPort;
    private final UpdateShowSeatUseCase updateShowSeatUseCase;

    public BookingEntity confirmBooking(Long bookingId) {
        BookingEntity booking = bookingPort.getBookingById(bookingId);
        booking.setStatus(BookingStatus.CONFIRMED.name());
        return booking;
    }


    @Transactional(rollbackFor = Exception.class)
    public BookingEntity cancelBooking(Long bookingId, Long userId) {
        var booking = bookingPort.getBookingById(bookingId);
        if (booking == null || !booking.getUserId().equals(userId)) {
            log.error("[UpdateBookingUseCase] booking not found");
            throw new UpdateBookingException();
        }

        var show = showPort.getShowById(booking.getShowId());
        Duration duration = Duration.between(LocalDateTime.now(), show.getStartTime());

        if (duration.toHours() < 1) {
            log.error("[UpdateBookingUseCase] exceeds valid duration to cancel booking");
            throw new UpdateBookingException();
        }

        updateShowSeatUseCase.cancelShowSeatsForBookingId(bookingId);

        booking.setStatus(BookingStatus.CANCELED.name());

        return booking;
    }
}
