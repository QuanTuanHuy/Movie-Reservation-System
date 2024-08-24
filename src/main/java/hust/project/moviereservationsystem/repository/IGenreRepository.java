package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.GenreModel;

import java.util.List;
import java.util.Optional;

public interface IGenreRepository extends IBaseRepository<GenreModel> {
    Optional<GenreModel> findByName(String name);

    List<GenreModel> findByIdIn(List<Long> ids);
}
