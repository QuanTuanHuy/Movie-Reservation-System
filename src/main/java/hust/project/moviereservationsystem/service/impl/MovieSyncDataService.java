package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.exception.CreateMovieElasticException;
import hust.project.moviereservationsystem.exception.DeleteMovieElasticException;
import hust.project.moviereservationsystem.exception.GetMovieElasticException;
import hust.project.moviereservationsystem.exception.UpdateMovieElasticException;
import hust.project.moviereservationsystem.model.document.MovieDocument;
import hust.project.moviereservationsystem.repository.IMovieElasticsearchRepository;
import hust.project.moviereservationsystem.service.IMovieSyncDataService;
import hust.project.moviereservationsystem.usecase.GetMovieUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieSyncDataService implements IMovieSyncDataService {

    private final GetMovieUseCase getMovieUseCase;

    private final IMovieElasticsearchRepository movieElasticsearchRepository;

    @Override
    public MovieEntity getMovieById(Long id) {
        return getMovieUseCase.getDetailMovie(id);
    }

    @Override
    public void createMovie(Long id) {
        var movieEntity = getMovieById(id);

        var movieDocument = MovieDocument.builder()
                .id(id)
                .title(movieEntity.getTitle())
                .description(movieEntity.getDescription())
                .duration(movieEntity.getDuration())
//                .releaseDate(movieEntity.getReleaseDate())
                .language(movieEntity.getLanguage())
                .country(movieEntity.getCountry())
                .actors(Arrays.stream(movieEntity.getActors().split(",")).toList())
                .genres(movieEntity.getGenres().stream().map(GenreEntity::getName).toList())
                .director(movieEntity.getDirector())
                .bannerImg(movieEntity.getBannerImg())
                .trailer(movieEntity.getTrailer())
                .ageLimit(movieEntity.getAgeLimit())
                .build();

        try {
            movieElasticsearchRepository.save(movieDocument);
            log.info("[MovieSyncDataService] Create movie with id: {}", id);
        } catch (Exception e) {
            log.error("[MovieSyncDataService] Error when create movie with id: {}", id);
            throw new CreateMovieElasticException();
        }

    }

    @Override
    public void updateMovie(Long id) {
        movieElasticsearchRepository.findById(id).orElseThrow(GetMovieElasticException::new);

        var movieEntity = getMovieById(id);

        var movieDocument = MovieDocument.builder()
                .id(id)
                .title(movieEntity.getTitle())
                .description(movieEntity.getDescription())
                .duration(movieEntity.getDuration())
//                .releaseDate(movieEntity.getReleaseDate())
                .language(movieEntity.getLanguage())
                .country(movieEntity.getCountry())
                .actors(Arrays.stream(movieEntity.getActors().split(",")).toList())
                .genres(movieEntity.getGenres().stream().map(GenreEntity::getName).toList())
                .director(movieEntity.getDirector())
                .bannerImg(movieEntity.getBannerImg())
                .trailer(movieEntity.getTrailer())
                .ageLimit(movieEntity.getAgeLimit())
                .build();

        try {
            movieElasticsearchRepository.save(movieDocument);
        } catch (Exception e) {
            log.error("[MovieSyncDataService] Error when update movie with id: {}", id);
            throw new UpdateMovieElasticException();
        }
    }

    @Override
    public void deleteMovie(Long id) {
        try {
            movieElasticsearchRepository.deleteById(id);
        } catch (Exception e) {
            log.error("[MovieSyncDataService] Error when delete movie with id: {}", id);
            throw new DeleteMovieElasticException();
        }
    }
}
