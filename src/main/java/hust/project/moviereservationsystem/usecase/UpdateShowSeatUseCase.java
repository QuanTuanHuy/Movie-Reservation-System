package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.exception.UpdateShowSeatException;
import hust.project.moviereservationsystem.port.IShowSeatPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateShowSeatUseCase {
    private final IShowSeatPort showSeatPort;

    @Transactional(rollbackFor = Exception.class)
    public List<ShowSeatEntity> assignShowSeatsToUser(List<Long> showSeatIds, Long userId) {
        List<ShowSeatEntity> showSeats = showSeatPort.getShowSeatsByIds(showSeatIds);

        boolean isValidSeats = showSeats.stream().noneMatch(showSeat -> showSeat.getIsReserved().equals(Boolean.TRUE));

        if (!isValidSeats || showSeatIds.size() != showSeats.size()) {
            log.error("[UpdateShowSeatUseCase] not enough show seats");
            throw new UpdateShowSeatException();
        }

        // use redis later to semaphore
        showSeats = showSeats.stream().peek(showSeat -> {
            showSeat.setIsReserved(true);
            showSeat.setUserId(userId);
        }).toList();

        return showSeatPort.saveAll(showSeats);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<ShowSeatEntity> cancelShowSeatsForBookingId(Long bookingId) {

        List<ShowSeatEntity> showSeats = showSeatPort.getShowSeatsByBookingId(bookingId);

        showSeats = showSeats.stream().peek(showSeat -> {
            showSeat.setIsReserved(false);
            showSeat.setBookingId(null);
            showSeat.setUserId(null);
        }).toList();

        return showSeatPort.saveAll(showSeats);
    }
}
