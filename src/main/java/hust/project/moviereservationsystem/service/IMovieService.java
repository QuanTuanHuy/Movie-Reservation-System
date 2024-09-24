package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageResponse;

public interface IMovieService {
    MovieEntity createMovie(CreateMovieRequest request);

    PageResponse<MovieEntity> getAllMovies(GetMovieRequest filter);

    MovieEntity getDetailMovie(Long movieId);

    MovieEntity updateMovie(Long movieId, UpdateMovieRequest request);

    void deleteMovie(Long movieId);
}
