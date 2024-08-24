package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.mapper.CinemaHallMapper;
import hust.project.moviereservationsystem.port.ICinemaHallPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCinemaHallUseCase {
    private final ICinemaHallPort cinemaHallPort;

    public List<CinemaHallEntity> getCinemaHallsByCinemaId(Long cinemaId) {
        return cinemaHallPort.getCinemaHallsByCinemaId(cinemaId);
    }
}
