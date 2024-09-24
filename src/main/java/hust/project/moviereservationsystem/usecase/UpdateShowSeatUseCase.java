package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.exception.RedisConnectionException;
import hust.project.moviereservationsystem.exception.UpdateShowSeatException;
import hust.project.moviereservationsystem.port.IRedisPort;
import hust.project.moviereservationsystem.port.IShowSeatPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UpdateShowSeatUseCase {
    private final IShowSeatPort showSeatPort;
    private final IRedisPort redisPort;
    private static final String PREFIX_LOCK_KEY = "show_seats:";

    public List<ShowSeatEntity> assignShowSeatsToUser(List<Long> showSeatIds, Long userId) {
        List<ShowSeatEntity> showSeats = showSeatPort.getShowSeatsByIds(showSeatIds);

        boolean isValidSeats = showSeats.stream().noneMatch(showSeat -> showSeat.getIsReserved().equals(Boolean.TRUE));

        if (!isValidSeats || showSeatIds.size() != showSeats.size()) {
            log.error("[UpdateShowSeatUseCase] not enough show seats");
            throw new UpdateShowSeatException();
        }

        for (var showSeat : showSeats) {
            String lockKey = PREFIX_LOCK_KEY + showSeat.getId();

            while (true) {
                try {
                    if (redisPort.tryLock(lockKey, userId.toString(), 10L)) {
                        showSeat.setIsReserved(true);
                        showSeat.setUserId(userId);
                        break;
                    }
                }
                catch (RedisConnectionException e) {
                    log.error("[UpdateShowSeatUseCase] Redis connection error");
                    throw new RedisConnectionException();
                } finally {
                    log.info("[UpdateShowSeatUseCase] release lock, {}", lockKey);
                    redisPort.releaseLock(lockKey);
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted");
                }
            }
        }

        return showSeatPort.saveAll(showSeats);
    }

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
