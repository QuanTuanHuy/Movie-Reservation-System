package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.CreateShowRequest;
import hust.project.moviereservationsystem.entity.request.GetShowRequest;
import hust.project.moviereservationsystem.entity.response.AllShowsResponse;
import hust.project.moviereservationsystem.entity.response.CinemaShowResponse;

import java.time.LocalDate;

public interface IShowService {
    ShowEntity createShow(CreateShowRequest createShowRequest);

    ShowEntity getDetailShow(Long id);

    AllShowsResponse getAllShows(GetShowRequest filter);

    CinemaShowResponse getShowsByCinemaIdAndDate(Long cinemaId, LocalDate date);

    void deleteShow(Long id);
}
