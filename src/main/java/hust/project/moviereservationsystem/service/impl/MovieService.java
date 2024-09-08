package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.IMovieService;
import hust.project.moviereservationsystem.usecase.CreateMovieUseCase;
import hust.project.moviereservationsystem.usecase.DeleteMovieUseCase;
import hust.project.moviereservationsystem.usecase.GetMovieUseCase;
import hust.project.moviereservationsystem.usecase.UpdateMovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {
    private final CreateMovieUseCase createMovieUseCase;
    private final GetMovieUseCase getMovieUseCase;
    private final UpdateMovieUseCase updateMovieUseCase;
    private final DeleteMovieUseCase deleteMovieUseCase;

    @Override
    public MovieEntity createMovie(CreateMovieRequest request) {
        return createMovieUseCase.createMovie(request);
    }

    @Override
    public Pair<PageInfo, List<MovieEntity>> getAllMovies(GetMovieRequest filter) {
        return getMovieUseCase.getAllMovies(filter);
    }

    @Override
    public MovieEntity getDetailMovie(Long movieId) {
        return getMovieUseCase.getDetailMovie(movieId);
    }

    @Override
    public MovieEntity updateMovie(Long movieId, UpdateMovieRequest request) {
        return updateMovieUseCase.updateMovie(movieId, request);
    }

    @Override
    public void deleteMovie(Long movieId) {
        deleteMovieUseCase.deleteMovie(movieId);
    }
}
