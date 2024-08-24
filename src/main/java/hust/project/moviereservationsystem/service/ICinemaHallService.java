package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallRequest;

import java.util.List;

public interface ICinemaHallService {
    public CinemaHallEntity createCinemaHall(CreateCinemaHallRequest request);

    public List<CinemaHallEntity> getCinemaHallsByCinemaId(Long cinemaId);
}
