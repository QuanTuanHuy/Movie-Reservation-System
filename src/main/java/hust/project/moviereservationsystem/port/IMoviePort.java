package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IMoviePort {
    MovieEntity save(MovieEntity movieEntity);

    Pair<PageInfo, List<MovieEntity>> getAllMovies(GetMovieRequest filter);

    MovieEntity getMovieById(Long movieId);

    List<MovieEntity> getMoviesByIds(List<Long> movieIds);

    void deleteMovieById(Long movieId);
}
