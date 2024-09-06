package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.RatingModel;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRatingRepository extends IBaseRepository<RatingModel> {
    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    @Query("SELECT SUM(rm.ratingStar), COUNT(rm.id) FROM RatingModel rm WHERE rm.movieId = :movieId")
    List<Object[]> getTotalStarAndTotalRating(@Param("movieId") Long movieId);
}
