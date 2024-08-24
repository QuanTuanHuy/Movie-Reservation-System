package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.MovieModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends IBaseRepository<MovieModel> {
    List<MovieModel> findByIdIn(List<Long> ids);
}
