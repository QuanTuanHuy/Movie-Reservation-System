package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;

import java.util.List;

public interface ICinemaHallPort {
    CinemaHallEntity save(CinemaHallEntity cinemaHallEntity);

    List<CinemaHallEntity> getCinemaHallsByCinemaId(Long cinemaId);

    List<CinemaHallEntity> getCinemaHallsByIds(List<Long> ids);

    CinemaHallEntity getCinemaHallById(Long id);

    void deleteCinemaHallById(Long cinemaHallId);
}
