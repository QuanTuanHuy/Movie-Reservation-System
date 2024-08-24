package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.MovieGenreEntity;

import java.util.List;

public interface IMovieGenrePort {
    MovieGenreEntity save(MovieGenreEntity movieGenreEntity);

    List<MovieGenreEntity> getByGenreIds(List<Long> genreIds);

    List<MovieGenreEntity> getByMovieIds(List<Long> movieIds);
}
