package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.MovieGenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.exception.CreateMovieException;
import hust.project.moviereservationsystem.mapper.MovieMapper;
import hust.project.moviereservationsystem.port.IGenrePort;
import hust.project.moviereservationsystem.port.IMovieGenrePort;
import hust.project.moviereservationsystem.port.IMoviePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CreateMovieUseCase {
    private final IMoviePort moviePort;
    private final MovieMapper movieMapper;
    private final IGenrePort genrePort;
    private final IMovieGenrePort movieGenrePort;

    public MovieEntity createMovie(CreateMovieRequest movieRequest) {
        var movieEntity = movieMapper.toEntityFromRequest(movieRequest);
        movieEntity = moviePort.save(movieEntity);

        var genreIds = movieRequest.getGenreIds();
        var genres = genrePort.getGenresByIds(genreIds);

        if (genreIds.size() != genres.size()) {
            log.error("[CreateMovieUseCase] not found enough genres in request");
            throw new CreateMovieException();
        }

        final Long movieId = movieEntity.getId();

        List<MovieGenreEntity> movieGenreEntities =  genres.stream().map(genre -> {
            MovieGenreEntity movieGenreEntity = new MovieGenreEntity();
            movieGenreEntity.setMovieId(movieId);
            movieGenreEntity.setGenreId(genre.getId());
            return movieGenreEntity;
        }).toList();

        movieGenrePort.saveAll(movieGenreEntities);

        movieEntity.setGenres(genres);
        return movieEntity;
    }
}
