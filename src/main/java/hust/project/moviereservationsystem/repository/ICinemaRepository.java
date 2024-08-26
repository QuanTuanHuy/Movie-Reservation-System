package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.CinemaModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICinemaRepository extends IBaseRepository<CinemaModel> {
    List<CinemaModel> findByIdIn(List<Long> ids);
}
