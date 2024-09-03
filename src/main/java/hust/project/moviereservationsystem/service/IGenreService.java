package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateGenreRequest;

import java.util.List;

public interface IGenreService {
    GenreEntity createGenre(CreateGenreRequest request);

    GenreEntity getDetailGenre(Long genreId);

    List<GenreEntity> getAllGenres();

    void deleteGenre(Long genreId);
}
