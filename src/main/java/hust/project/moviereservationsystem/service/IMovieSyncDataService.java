package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.MovieEntity;

// sync data to elasticsearch
public interface IMovieSyncDataService {
    MovieEntity getMovieById(Long id);

    void createMovie(Long id);

    void updateMovie(Long id);

    void deleteMovie(Long id);
}
