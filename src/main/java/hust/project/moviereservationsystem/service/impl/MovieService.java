package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateMovieRequest;
import hust.project.moviereservationsystem.entity.response.GetAllEntityResponse;
import hust.project.moviereservationsystem.event.dto.MovieCreatedEvent;
import hust.project.moviereservationsystem.service.IMovieService;
import hust.project.moviereservationsystem.usecase.CreateMovieUseCase;
import hust.project.moviereservationsystem.usecase.DeleteMovieUseCase;
import hust.project.moviereservationsystem.usecase.GetMovieUseCase;
import hust.project.moviereservationsystem.usecase.UpdateMovieUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
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
                .movieId(movie.getId())
                .build();

        kafkaTemplate.send("new_movie_created", movieCreatedEvent);

        return movie;
    }

    @Override
    @Cacheable(value = "movies", key = "#filter.getPage() + '-' + #filter.getPageSize() + '-' + #filter.getTitle() + " +
            "'-' + #filter.getReleaseDate() + '-' + #filter.getLanguage() + '-' + #filter.getGenre()")
    public GetAllEntityResponse getAllMovies(GetMovieRequest filter) {
        var result = getMovieUseCase.getAllMovies(filter);
        return new GetAllEntityResponse(result.getFirst(), result.getSecond());
    }

    @Override
    @Cacheable(value = "movies", key = "#movieId")
    public MovieEntity getDetailMovie(Long movieId) {
        log.info("cache miss");
        return getMovieUseCase.getDetailMovie(movieId);
    }

    @Override
    @CachePut(value = "movies", key = "#movieId")
    public MovieEntity updateMovie(Long movieId, UpdateMovieRequest request) {
        return updateMovieUseCase.updateMovie(movieId, request);
    }

    @Override
    @CacheEvict(value = "movies", key = "#movieId")
    public void deleteMovie(Long movieId) {
        deleteMovieUseCase.deleteMovie(movieId);
    }
}
