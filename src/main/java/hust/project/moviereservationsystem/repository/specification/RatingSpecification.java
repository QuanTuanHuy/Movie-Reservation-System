package hust.project.moviereservationsystem.repository.specification;

import hust.project.moviereservationsystem.entity.request.GetRatingRequest;
import hust.project.moviereservationsystem.model.RatingModel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RatingSpecification {
    public static Specification<RatingModel> getAll(GetRatingRequest filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getMovieId() != null) {
                predicates.add(builder.equal(root.get("movieId"), filter.getMovieId()));
            }

            if (filter.getUserId() != null) {
                predicates.add(builder.equal(root.get("userId"), filter.getUserId()));
            }

            if (filter.getRatingStar() != null) {
                predicates.add(builder.equal(root.get("ratingStar"), filter.getRatingStar()));
            }

            if (filter.getContent() != null) {
                predicates.add(builder.like(root.get("content"), "%".concat(filter.getContent()).concat("%")));
            }

            if (filter.getUserName() != null) {
                predicates.add(builder.like(root.get("userName"), "%".concat(filter.getUserName()).concat("%")));
            }

            if (filter.getCreatedFrom() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("createdOn"), filter.getCreatedFrom()));
            }

            if (filter.getCreatedTo() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("createdOn"), filter.getCreatedTo()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
