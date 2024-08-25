package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ICinemaHallSeatService {
    CinemaHallSeatEntity createCinemaHallSeat(CreateCinemaHallSeatRequest request);

    Pair<PageInfo, List<CinemaHallSeatEntity>> getAll(GetCinemaHallSeatRequest filter);

    CinemaHallSeatEntity updateCinemaHallSeat(Long id, UpdateCinemaHallSeatRequest request);
}
