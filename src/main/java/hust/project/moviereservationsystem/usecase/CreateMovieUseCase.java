package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.MovieGenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.mapper.MovieMapper;
import hust.project.moviereservationsystem.port.IGenrePort;
import hust.project.moviereservationsystem.port.IMovieGenrePort;
import hust.project.moviereservationsystem.port.IMoviePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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

        final Long movieId = movieEntity.getId();

        genres.forEach(genre -> {
            var movieGenre = new MovieGenreEntity();
            movieGenre.setGenreId(genre.getId());
            movieGenre.setMovieId(movieId);

            movieGenrePort.save(movieGenre);
        });

        movieEntity.setGenres(genres);
        return movieEntity;
    }
}
