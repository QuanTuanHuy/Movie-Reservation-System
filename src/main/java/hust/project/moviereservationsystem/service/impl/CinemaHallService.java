package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallRequest;
import hust.project.moviereservationsystem.service.ICinemaHallService;
import hust.project.moviereservationsystem.usecase.CreateCinemaHallUseCase;
import hust.project.moviereservationsystem.usecase.GetCinemaHallUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaHallService implements ICinemaHallService {
    private final CreateCinemaHallUseCase createCinemaHallUseCase;
    private final GetCinemaHallUseCase getCinemaHallUseCase;

    @Override
    public CinemaHallEntity createCinemaHall(CreateCinemaHallRequest request) {
        return createCinemaHallUseCase.createCinemaHall(request);
    }

    @Override
    public List<CinemaHallEntity> getCinemaHallsByCinemaId(Long cinemaId) {
        return getCinemaHallUseCase.getCinemaHallsByCinemaId(cinemaId);
    }
}
