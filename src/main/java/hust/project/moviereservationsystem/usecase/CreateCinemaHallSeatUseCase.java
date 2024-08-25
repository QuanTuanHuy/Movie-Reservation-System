package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.exception.CreateCinemaHallSeatException;
import hust.project.moviereservationsystem.mapper.CinemaHallSeatMapper;
import hust.project.moviereservationsystem.port.ICinemaHallSeatPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateCinemaHallSeatUseCase {
    private final ICinemaHallSeatPort cinemaHallSeatPort;
    private final CinemaHallSeatMapper cinemaHallSeatMapper;

    public CinemaHallSeatEntity createCinemaHallSeat(CreateCinemaHallSeatRequest request) {
        var existedSeat = cinemaHallSeatPort.getByCodeAndCinemaHallId(request.getCode(), request.getCinemaHallId());

        if (existedSeat != null) {
            throw new CreateCinemaHallSeatException();
        }

        var seatEntity = cinemaHallSeatMapper.toEntityFromRequest(request);
        return cinemaHallSeatPort.save(seatEntity);
    }
}
