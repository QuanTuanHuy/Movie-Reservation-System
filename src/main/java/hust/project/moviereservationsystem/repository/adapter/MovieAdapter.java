package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.exception.CreateMovieException;
import hust.project.moviereservationsystem.exception.DeleteMovieException;
import hust.project.moviereservationsystem.exception.GetMovieException;
import hust.project.moviereservationsystem.mapper.MovieMapper;
import hust.project.moviereservationsystem.model.MovieModel;
import hust.project.moviereservationsystem.port.IMoviePort;
import hust.project.moviereservationsystem.repository.ICustomMovieRepository;
import hust.project.moviereservationsystem.repository.IMovieRepository;
import hust.project.moviereservationsystem.utils.PageInfoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieAdapter implements IMoviePort {
    private final IMovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final ICustomMovieRepository customMovieRepository;

    @Override
    public MovieEntity save(MovieEntity movieEntity) {
        try {
            MovieModel movieModel = movieMapper.toModelFromEntity(movieEntity);
            return movieMapper.toEntityFromModel(movieRepository.save(movieModel));
        } catch (Exception e) {
            throw new CreateMovieException();
        }
    }

    @Override
    public Pair<PageInfo, List<MovieEntity>> getAllMovies(GetMovieRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()),
                Math.toIntExact(filter.getPageSize()), Sort.by("id").descending());

        var result = customMovieRepository.getAllMovies(filter, pageable);
        var pageInfo = PageInfoUtils.getPageInfo(result);

        return Pair.of(pageInfo, movieMapper.toEntitiesFromModels(result.getContent()));
    }

    @Override
    public MovieEntity getMovieById(Long movieId) {
        return movieMapper.toEntityFromModel(movieRepository.findById(movieId)
                .orElseThrow(GetMovieException::new));
    }

    @Override
    public List<MovieEntity> getMoviesByIds(List<Long> movieIds) {
        return movieMapper.toEntitiesFromModels(movieRepository.findByIdIn(movieIds));
    }

    @Override
    public void deleteMovieById(Long movieId) {
        try {
            movieRepository.deleteById(movieId);
        } catch (Exception e) {
            throw new DeleteMovieException();
        }
    }
}
