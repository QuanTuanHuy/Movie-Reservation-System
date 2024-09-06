package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.RatingEntity;
import hust.project.moviereservationsystem.entity.request.GetRatingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.port.IMoviePort;
import hust.project.moviereservationsystem.port.IRatingPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetRatingUseCase {
    private final IRatingPort ratingPort;
    private final IMoviePort moviePort;

    public Pair<PageInfo, List<RatingEntity>> getAllRatings(GetRatingRequest filter) {
        return ratingPort.getAllRatings(filter);
    }

    public Double getAverageStarByMovieId(Long movieId) {
        MovieEntity movie = moviePort.getMovieById(movieId);

        Pair<Long, Long> totalStarAndTotalRating = ratingPort.getTotalStarsAndTotalRatingsByMovieId(movieId);
        return totalStarAndTotalRating.getFirst() * 1.0 / totalStarAndTotalRating.getSecond();
    }
}
