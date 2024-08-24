package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.MovieGenreEntity;
import hust.project.moviereservationsystem.exception.CreateMovieGenreException;
import hust.project.moviereservationsystem.mapper.MovieGenreMapper;
import hust.project.moviereservationsystem.port.IMovieGenrePort;
import hust.project.moviereservationsystem.repository.IMovieGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieGenreAdapter implements IMovieGenrePort {
    private final IMovieGenreRepository movieGenreRepository;
    private final MovieGenreMapper movieGenreMapper;

    @Override
    public MovieGenreEntity save(MovieGenreEntity movieGenreEntity) {
        try {
            var movieGenreModel = movieGenreMapper.toModelFromEntity(movieGenreEntity);
            return movieGenreMapper.toEntityFromModel(movieGenreRepository.save(movieGenreModel));
        } catch (Exception e) {
            throw new CreateMovieGenreException();
        }
    }

    @Override
    public List<MovieGenreEntity> getByGenreIds(List<Long> genreIds) {
        return movieGenreMapper.toEntitiesFromModels(movieGenreRepository.findByGenreIdIn(genreIds));
    }

    @Override
    public List<MovieGenreEntity> getByMovieIds(List<Long> movieIds) {
        return movieGenreMapper.toEntitiesFromModels(movieGenreRepository.findByMovieIdIn(movieIds));
    }
}
