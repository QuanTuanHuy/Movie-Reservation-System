package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.MovieGenreEntity;

import java.util.List;

public interface IMovieGenrePort {
    MovieGenreEntity save(MovieGenreEntity movieGenreEntity);

    void saveAll(List<MovieGenreEntity> movieGenreEntities);

    List<MovieGenreEntity> getByGenreIds(List<Long> genreIds);

    List<MovieGenreEntity> getByMovieIds(List<Long> movieIds);

    void deleteByMovieId(Long movieId);
}
