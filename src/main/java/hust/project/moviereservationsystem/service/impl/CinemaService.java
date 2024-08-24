package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaRequest;
import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.ICinemaService;
import hust.project.moviereservationsystem.usecase.CreateCinemaUseCase;
import hust.project.moviereservationsystem.usecase.DeleteCinemaUseCase;
import hust.project.moviereservationsystem.usecase.GetCinemaUseCase;
import hust.project.moviereservationsystem.usecase.UpdateCinemaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService implements ICinemaService {
    private final CreateCinemaUseCase createCinemaUseCase;
    private final GetCinemaUseCase getCinemaUseCase;
    private final UpdateCinemaUseCase updateCinemaUseCase;
    private final DeleteCinemaUseCase deleteCinemaUseCase;

    @Override
    public CinemaEntity createCinema(CreateCinemaRequest createCinemaRequest) {
        return createCinemaUseCase.createCinema(createCinemaRequest);
    }

    @Override
    public Pair<PageInfo, List<CinemaEntity>> getAllCinemas(GetCinemaRequest filter) {
        return getCinemaUseCase.getAllCinemas(filter);
    }

    @Override
    public CinemaEntity getDetailCinema(Long cinemaId) {
        return getCinemaUseCase.getDetailCinema(cinemaId);
    }

    @Override
    public CinemaEntity updateCinema(Long cinemaId, UpdateCinemaRequest request) {
        return updateCinemaUseCase.updateCinema(cinemaId, request);
    }

    @Override
    public void deleteCinema(Long cinemaId) {
        deleteCinemaUseCase.deleteCinema(cinemaId);
    }
}
