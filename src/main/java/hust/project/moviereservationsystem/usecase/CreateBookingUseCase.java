package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.constant.BookingStatus;
import hust.project.moviereservationsystem.constant.PaymentStatus;
import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.entity.request.CreateBookingRequest;
import hust.project.moviereservationsystem.exception.CreateBookingException;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.IShowPort;
import hust.project.moviereservationsystem.port.IShowSeatPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateBookingUseCase {
    private final IBookingPort bookingPort;
    private final IShowSeatPort showSeatPort;
    private final IShowPort showPort;

    @Transactional(rollbackFor = Exception.class)
    public BookingEntity createBooking(CreateBookingRequest request, Long userId) {
        List<Long> showSeatIds = request.getShowSeatIds();

        List<ShowSeatEntity> showSeats = showSeatPort.getShowSeatsByIds(showSeatIds);

        if (showSeats.size() != showSeatIds.size()) {
            log.error("[CreateBookingUseCase] not enough show seats");
            throw new CreateBookingException();
        }

        boolean valid = true;
        for (var showSeat : showSeats) {
            if (!showSeat.getUserId().equals(userId) || !showSeat.getShowId().equals(request.getShowId())) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            log.error("[CreateBookingUseCase] not enough show seats or wrong user id");
            throw new CreateBookingException();
        }

        var totalPrice = showSeats.stream().mapToLong(ShowSeatEntity::getPrice).sum();

        BookingEntity booking = new BookingEntity();
        booking.setUserId(userId);
        booking.setShowId(request.getShowId());
        booking.setTotalPrice(totalPrice);
        booking.setCreatedAt(LocalDateTime.now());
        booking.setNote(request.getNote());
        booking.setStatus(BookingStatus.PENDING.name());
        booking.setTotalSeats((long) showSeatIds.size());
        booking.setPaymentMethod(request.getPaymentMethod());
        booking.setPaymentStatus(PaymentStatus.PENDING.name());

        booking = bookingPort.save(booking);

        final Long bookingId = booking.getId();

        showSeats = showSeats.stream().peek(showSeat -> showSeat.setBookingId(bookingId)).toList();
        showSeatPort.saveAll(showSeats);

        var show = showPort.getShowById(booking.getShowId());
        booking.setShow(show);

        return booking;
    }
}
