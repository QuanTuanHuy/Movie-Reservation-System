package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.ICinemaHallSeatService;
import hust.project.moviereservationsystem.usecase.CreateCinemaHallSeatUseCase;
import hust.project.moviereservationsystem.usecase.GetCinemaHallSeatUseCase;
import hust.project.moviereservationsystem.usecase.UpdateCinemaHallSeatUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaHallSeatService implements ICinemaHallSeatService {
    private final CreateCinemaHallSeatUseCase createCinemaHallSeatUseCase;
    private final GetCinemaHallSeatUseCase getCinemaHallSeatUseCase;
    private final UpdateCinemaHallSeatUseCase updateCinemaHallSeatUseCase;

    @Override
    public CinemaHallSeatEntity createCinemaHallSeat(CreateCinemaHallSeatRequest request) {
        return createCinemaHallSeatUseCase.createCinemaHallSeat(request);
    }

    @Override
    public Pair<PageInfo, List<CinemaHallSeatEntity>> getAll(GetCinemaHallSeatRequest filter) {
        return getCinemaHallSeatUseCase.getAll(filter);
    }

    @Override
    public CinemaHallSeatEntity updateCinemaHallSeat(Long id, UpdateCinemaHallSeatRequest request) {
        return updateCinemaHallSeatUseCase.updateCinemaHallSeat(id, request);
    }
}
