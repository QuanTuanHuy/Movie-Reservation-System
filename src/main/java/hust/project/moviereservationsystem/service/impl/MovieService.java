package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.event.dto.MovieCreatedEvent;
import hust.project.moviereservationsystem.event.dto.NotificationEvent;
import hust.project.moviereservationsystem.service.IMovieService;
import hust.project.moviereservationsystem.usecase.CreateMovieUseCase;
import hust.project.moviereservationsystem.usecase.DeleteMovieUseCase;
import hust.project.moviereservationsystem.usecase.GetMovieUseCase;
import hust.project.moviereservationsystem.usecase.UpdateMovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {
    private final CreateMovieUseCase createMovieUseCase;
    private final GetMovieUseCase getMovieUseCase;
    private final UpdateMovieUseCase updateMovieUseCase;
    private final DeleteMovieUseCase deleteMovieUseCase;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public MovieEntity createMovie(CreateMovieRequest request) {
        MovieEntity movie =  createMovieUseCase.createMovie(request);

        MovieCreatedEvent movieCreatedEvent = MovieCreatedEvent.builder()
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate().toString())
                .movieInfoUrl("localhost:5454/api/v1/movies/" + movie.getId())
                .build();

        kafkaTemplate.send("new_movie_created", movieCreatedEvent);

        return movie;
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
