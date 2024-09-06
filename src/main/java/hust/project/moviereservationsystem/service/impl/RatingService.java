package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.RatingEntity;
import hust.project.moviereservationsystem.entity.request.CreateRatingRequest;
import hust.project.moviereservationsystem.entity.request.GetRatingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.IRatingService;
import hust.project.moviereservationsystem.usecase.CreateRatingUseCase;
import hust.project.moviereservationsystem.usecase.DeleteRatingUseCase;
import hust.project.moviereservationsystem.usecase.GetRatingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService implements IRatingService {
    private final CreateRatingUseCase createRatingUseCase;
    private final GetRatingUseCase getRatingUseCase;
    private final DeleteRatingUseCase deleteRatingUseCase;

    @Override
    public RatingEntity createRating(CreateRatingRequest request, Long userId) {
        return createRatingUseCase.createRating(request, userId);
    }

    @Override
    public Pair<PageInfo, List<RatingEntity>> getAllRatings(GetRatingRequest filter) {
        return getRatingUseCase.getAllRatings(filter);
    }

    @Override
    public Double getAverageStarByMovieId(Long movieId) {
        return getRatingUseCase.getAverageStarByMovieId(movieId);
    }

    @Override
    public void deleteRating(Long id) {
        deleteRatingUseCase.deleteRating(id);
    }
}
