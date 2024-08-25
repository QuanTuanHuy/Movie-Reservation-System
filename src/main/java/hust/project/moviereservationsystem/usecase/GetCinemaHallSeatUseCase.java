package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.port.ICinemaHallSeatPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCinemaHallSeatUseCase {
    private final ICinemaHallSeatPort cinemaHallSeatPort;

    public Pair<PageInfo, List<CinemaHallSeatEntity>> getAll(GetCinemaHallSeatRequest filter) {
        return cinemaHallSeatPort.getAll(filter);
    }
}
