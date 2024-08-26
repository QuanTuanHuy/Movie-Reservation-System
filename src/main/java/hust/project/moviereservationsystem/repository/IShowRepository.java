package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.ShowModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShowRepository extends IBaseRepository<ShowModel> {
    List<ShowModel> findByCinemaHallIdIn(List<Long> cinemaHallIds);
}
