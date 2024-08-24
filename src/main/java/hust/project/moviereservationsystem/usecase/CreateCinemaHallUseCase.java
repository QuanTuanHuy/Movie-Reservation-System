package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallRequest;
import hust.project.moviereservationsystem.mapper.CinemaHallMapper;
import hust.project.moviereservationsystem.port.ICinemaHallPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCinemaHallUseCase {
    private final ICinemaHallPort cinemaHallPort;
    private final CinemaHallMapper cinemaHallMapper;

    @Transactional(rollbackFor = Exception.class)
    public CinemaHallEntity createCinemaHall(CreateCinemaHallRequest request) {
        return cinemaHallPort.save(cinemaHallMapper.toEntityFromRequest(request));
    }
}
