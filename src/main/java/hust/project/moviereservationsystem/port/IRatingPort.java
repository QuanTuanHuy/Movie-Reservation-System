package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.RatingEntity;
import hust.project.moviereservationsystem.entity.request.GetRatingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IRatingPort {
    RatingEntity save(RatingEntity ratingEntity);

    Pair<PageInfo, List<RatingEntity>> getAllRatings(GetRatingRequest filter);

    void deleteById(Long id);

    Pair<Long, Long> getTotalStarsAndTotalRatingsByMovieId(Long movieId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);
}
