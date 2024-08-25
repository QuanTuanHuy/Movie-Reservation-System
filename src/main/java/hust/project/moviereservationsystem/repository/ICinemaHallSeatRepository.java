package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.CinemaHallSeatModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICinemaHallSeatRepository extends IBaseRepository<CinemaHallSeatModel> {
    List<CinemaHallSeatModel> findByCinemaHallId(Long cinemaHallId);

    Optional<CinemaHallSeatModel> findByCodeAndCinemaHallId(String code, Long cinemaHallId);
}
