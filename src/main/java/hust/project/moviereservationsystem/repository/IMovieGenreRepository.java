package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.MovieGenreModel;

import java.util.List;

public interface IMovieGenreRepository extends IBaseRepository<MovieGenreModel> {
    List<MovieGenreModel> findByGenreIdIn(List<Long> genreIds);

    List<MovieGenreModel> findByMovieIdIn(List<Long> movieIds);
}
