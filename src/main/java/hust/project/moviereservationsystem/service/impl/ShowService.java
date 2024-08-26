package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.CreateShowRequest;
import hust.project.moviereservationsystem.entity.request.GetShowRequest;
import hust.project.moviereservationsystem.entity.response.AllShowsResponse;
import hust.project.moviereservationsystem.entity.response.CinemaShowResponse;
import hust.project.moviereservationsystem.service.IShowService;
import hust.project.moviereservationsystem.usecase.CreateShowUseCase;
import hust.project.moviereservationsystem.usecase.DeleteShowUseCase;
import hust.project.moviereservationsystem.usecase.GetShowUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ShowService implements IShowService {
    private final CreateShowUseCase createShowUseCase;
    private final GetShowUseCase getShowUseCase;
    private final DeleteShowUseCase deleteShowUseCase;

    @Override
    public ShowEntity createShow(CreateShowRequest createShowRequest) {
        return createShowUseCase.createShow(createShowRequest);
    }

    @Override
    public ShowEntity getDetailShow(Long id) {
        return getShowUseCase.getDetailShow(id);
    }

    @Override
    public AllShowsResponse getAllShows(GetShowRequest filter) {
        return getShowUseCase.getAllShows(filter);
    }

    @Override
    public CinemaShowResponse getShowsByCinemaIdAndDate(Long cinemaId, LocalDate date) {
        return getShowUseCase.getShowsByCinemaIdAndDate(cinemaId, date);
    }

    @Override
    public void deleteShow(Long id) {
        deleteShowUseCase.deleteShow(id);
    }
}
