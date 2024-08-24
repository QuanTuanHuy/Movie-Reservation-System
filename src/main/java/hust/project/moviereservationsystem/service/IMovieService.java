package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IMovieService {
    MovieEntity createMovie(CreateMovieRequest request);

    Pair<PageInfo, List<MovieEntity>> getAllMovies(GetMovieRequest filter);

    MovieEntity getDetailMovie(Long movieId);

    void deleteMovie(Long movieId);
}
