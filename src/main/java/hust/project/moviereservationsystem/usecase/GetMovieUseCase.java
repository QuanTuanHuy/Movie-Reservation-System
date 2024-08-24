package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.BaseEntity;
import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.MovieGenreEntity;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.port.IGenrePort;
import hust.project.moviereservationsystem.port.IMovieGenrePort;
import hust.project.moviereservationsystem.port.IMoviePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMovieUseCase {
    private final IMoviePort moviePort;
    private final IGenrePort genrePort;
    private final IMovieGenrePort movieGenrePort;

    public Pair<PageInfo, List<MovieEntity>> getAllMovies(GetMovieRequest request) {
        var result = moviePort.getAllMovies(request);

        var movies = result.getSecond();
        var movieIds = movies.stream().map(BaseEntity::getId).toList();

        var movieGenres = movieGenrePort.getByMovieIds(movieIds);

        var genreIds = movieGenres.stream().map(MovieGenreEntity::getGenreId).toList();
        var genres = genrePort.getGenresByIds(genreIds);
        var mapIdToGenre = genres.stream().collect(Collectors.toMap(BaseEntity::getId, Function.identity()));

        for (var movie : movies) {
            var curMovieGenre = movieGenres.stream().filter(mg -> mg.getMovieId().equals(movie.getId())).toList();
            for (var mg : curMovieGenre) {
                movie.getGenres().add(mapIdToGenre.get(mg.getGenreId()));
            }
        }

        return result;
    }

    public MovieEntity getDetailMovie(Long movieId) {
        var movie = moviePort.getMovieById(movieId);

        var movieGenres = movieGenrePort.getByMovieIds(List.of(movie.getId()));
        var genreIds = movieGenres.stream().map(MovieGenreEntity::getGenreId).toList();

        var genres = genrePort.getGenresByIds(genreIds);
        movie.setGenres(genres);

        return movie;
    }


}
