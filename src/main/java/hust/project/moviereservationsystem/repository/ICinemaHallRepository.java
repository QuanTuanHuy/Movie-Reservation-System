package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.model.CinemaHallModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICinemaHallRepository extends IBaseRepository<CinemaHallModel> {
    List<CinemaHallModel> findByIdIn(List<Long> ids);

    List<CinemaHallModel> findByCinemaId(Long cinemaId);
}
