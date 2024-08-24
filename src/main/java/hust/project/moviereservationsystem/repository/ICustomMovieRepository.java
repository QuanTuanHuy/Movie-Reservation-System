package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.model.MovieModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomMovieRepository {
    Page<MovieModel> getAllMovies(GetMovieRequest filter, Pageable pageable);
}
