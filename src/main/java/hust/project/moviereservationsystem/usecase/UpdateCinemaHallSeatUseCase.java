package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.port.ICinemaHallSeatPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateCinemaHallSeatUseCase {
    private final ICinemaHallSeatPort cinemaHallSeatPort;

    public CinemaHallSeatEntity updateCinemaHallSeat(Long id, UpdateCinemaHallSeatRequest request) {
        var seatEntity = cinemaHallSeatPort.getById(id);

        if (StringUtils.hasText(request.getCode())) {
            seatEntity.setCode(request.getCode());
        }
        if (StringUtils.hasText(request.getType())) {
            seatEntity.setType(request.getType());
        }

        return cinemaHallSeatPort.save(seatEntity);
    }
}
