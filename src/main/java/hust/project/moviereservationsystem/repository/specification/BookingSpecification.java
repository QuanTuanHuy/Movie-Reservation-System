package hust.project.moviereservationsystem.repository.specification;

import hust.project.moviereservationsystem.entity.request.GetBookingRequest;
import hust.project.moviereservationsystem.model.BookingModel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BookingSpecification {
    public static Specification<BookingModel> getAll(GetBookingRequest filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getShowId() != null) {
                predicates.add(builder.equal(root.get("showId"), filter.getShowId()));
            }

            if (filter.getUserId() != null) {
                predicates.add(builder.equal(root.get("userId"), filter.getUserId()));
            }

            if (filter.getStatus() != null) {
                predicates.add(builder.equal(root.get("status"), filter.getStatus().toUpperCase()));
            }

            if (filter.getStartTime() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("createdAt"), filter.getStartTime()));
            }

            if (filter.getEndTime() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("createdAt"), filter.getEndTime()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
