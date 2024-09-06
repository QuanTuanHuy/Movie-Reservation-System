package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.RatingEntity;
import hust.project.moviereservationsystem.entity.request.CreateRatingRequest;
import hust.project.moviereservationsystem.entity.request.GetRatingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IRatingService {
    RatingEntity createRating(CreateRatingRequest request, Long userId);

    Pair<PageInfo, List<RatingEntity>> getAllRatings(GetRatingRequest filter);

    Double getAverageStarByMovieId(Long movieId);

    void deleteRating(Long id);
}
