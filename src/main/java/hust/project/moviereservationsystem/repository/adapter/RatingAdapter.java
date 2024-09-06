package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.RatingEntity;
import hust.project.moviereservationsystem.entity.request.GetRatingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.exception.CreateRatingException;
import hust.project.moviereservationsystem.exception.DeleteRatingException;
import hust.project.moviereservationsystem.mapper.RatingMapper;
import hust.project.moviereservationsystem.model.RatingModel;
import hust.project.moviereservationsystem.port.IRatingPort;
import hust.project.moviereservationsystem.repository.IRatingRepository;
import hust.project.moviereservationsystem.repository.specification.RatingSpecification;
import hust.project.moviereservationsystem.utils.PageInfoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingAdapter implements IRatingPort {
    private final IRatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public RatingEntity save(RatingEntity ratingEntity) {
        try {
            RatingModel ratingModel = ratingMapper.toModelFromEntity(ratingEntity);
            return ratingMapper.toEntityFromModel(ratingRepository.save(ratingModel));
        } catch (Exception e) {
            throw new CreateRatingException();
        }
    }

    @Override
    public Pair<PageInfo, List<RatingEntity>> getAllRatings(GetRatingRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("createdOn").descending());
        Page<RatingModel> pageRating = ratingRepository.findAll(RatingSpecification.getAll(filter), pageable);

        PageInfo pageInfo = PageInfoUtils.getPageInfo(pageRating);

        return Pair.of(pageInfo, ratingMapper.toEntitiesFromModels(pageRating.getContent()));
    }

    @Override
    public void deleteById(Long id) {
        try {
            ratingRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteRatingException();
        }
    }

    @Override
    public Pair<Long, Long> getTotalStarsAndTotalRatingsByMovieId(Long movieId) {
        List<Object[]> totalStarAndTotalRating = ratingRepository.getTotalStarAndTotalRating(movieId);
        if (ObjectUtils.isEmpty(totalStarAndTotalRating.get(0)[0])) {
            return Pair.of(0L, 1L);
        }
        Long totalStars = Long.parseLong(totalStarAndTotalRating.get(0)[0].toString());
        Long totalRatings = Long.parseLong(totalStarAndTotalRating.get(0)[1].toString());
        return Pair.of(totalStars, totalRatings);

    }

    @Override
    public boolean existsByUserIdAndMovieId(Long userId, Long movieId) {
        return ratingRepository.existsByUserIdAndMovieId(userId, movieId);
    }
}
