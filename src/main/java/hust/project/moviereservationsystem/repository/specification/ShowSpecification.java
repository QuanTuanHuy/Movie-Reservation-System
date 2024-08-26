package hust.project.moviereservationsystem.repository.specification;

import hust.project.moviereservationsystem.entity.request.GetShowRequest;
import hust.project.moviereservationsystem.model.ShowModel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowSpecification {
    public static Specification<ShowModel> getAllShows(GetShowRequest filter) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (filter.getMovieId() != null) {
                predicates.add(builder.equal(root.get("movieId"), filter.getMovieId()));
            }
            if (filter.getDate() != null) {
                var startOfDay = filter.getDate().atStartOfDay();
                var endOfDay = filter.getDate().atStartOfDay().plusDays(1);

                predicates.add(builder.between(root.get("startTime"), startOfDay, endOfDay));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<ShowModel> isOverlap(Long cinemaHallId, LocalDateTime internalTime) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            predicates.add(builder.equal(root.get("cinemaHallId"), cinemaHallId));
            predicates.add(builder.lessThanOrEqualTo(root.get("startTime"), internalTime));
            predicates.add(builder.greaterThanOrEqualTo(root.get("endTime"), internalTime));

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<ShowModel> getShowsByCinemaHallsIdsAndDate(List<Long> cinemaHallIds, LocalDate date) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            var startOfDay = date.atStartOfDay();
            var endOfDay = date.plusDays(1).atStartOfDay();

            predicates.add(builder.between(root.get("startTime"), startOfDay, endOfDay));


            if (!CollectionUtils.isEmpty(cinemaHallIds)) {
                predicates.add(root.get("cinemaHallId").in(cinemaHallIds));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
