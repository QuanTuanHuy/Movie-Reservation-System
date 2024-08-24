package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaRequest;
import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ICinemaService {
    CinemaEntity createCinema(CreateCinemaRequest createCinemaRequest);

    Pair<PageInfo, List<CinemaEntity>> getAllCinemas(GetCinemaRequest filter);

    CinemaEntity getDetailCinema(Long cinemaId);

    CinemaEntity updateCinema(Long cinemaId, UpdateCinemaRequest request);

    void deleteCinema(Long cinemaId);
}
