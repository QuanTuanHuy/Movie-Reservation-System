package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.GenreEntity;

import java.util.List;

public interface IGenrePort {
    GenreEntity save(GenreEntity genreEntity);

    GenreEntity getGenreById(Long genreId);

    List<GenreEntity> getGenresByIds(List<Long> genreIds);

    List<GenreEntity> getAllGenres();

    GenreEntity getGenreByName(String name);

    void deleteById(Long id);
}
