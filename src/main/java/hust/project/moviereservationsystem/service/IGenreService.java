package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateGenreRequest;

public interface IGenreService {
    GenreEntity createGenre(CreateGenreRequest request);

    GenreEntity getDetailGenre(Long genreId);
}
