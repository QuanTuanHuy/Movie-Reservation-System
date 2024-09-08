package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.MovieGenreEntity;
import hust.project.moviereservationsystem.entity.request.UpdateMovieRequest;
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
public class UpdateMovieUseCase {
    private final IMoviePort moviePort;
    private final MovieMapper movieMapper;
    private final IMovieGenrePort movieGenrePort;
    private final IGenrePort genrePort;

    public MovieEntity updateMovie(Long movieId, UpdateMovieRequest request) {
        moviePort.getMovieById(movieId);

        MovieEntity newMovie = movieMapper.toEntityFromRequest(request);
        newMovie.setId(movieId);

        var genreIds = request.getGenreIds();
        var genres = genrePort.getGenresByIds(genreIds);

        if (genreIds.size() != genres.size()) {
            log.error("[CreateMovieUseCase] not found enough genres in request");
            throw new CreateMovieException();
        }

        newMovie = moviePort.save(newMovie);
        newMovie.setGenres(genres);

        movieGenrePort.deleteByMovieId(movieId);

        List<MovieGenreEntity> movieGenres = genreIds.stream()
                .map(genreId -> {
                    MovieGenreEntity movieGenre = new MovieGenreEntity();
                    movieGenre.setGenreId(genreId);
                    movieGenre.setMovieId(movieId);
                    return movieGenre;
                })
                .toList();
        movieGenrePort.saveAll(movieGenres);

        return newMovie;
    }
}
