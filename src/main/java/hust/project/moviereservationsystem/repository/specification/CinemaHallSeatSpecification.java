package hust.project.moviereservationsystem.repository.specification;

import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.model.CinemaHallSeatModel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class CinemaHallSeatSpecification {
    public static Specification<CinemaHallSeatModel> getAll(GetCinemaHallSeatRequest filter) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (filter.getCinemaHallId() != null) {
                predicates.add(builder.equal(root.get("cinemaHallId"), filter.getCinemaHallId()));
            }
            if (StringUtils.hasText(filter.getType())) {
                predicates.add(builder.like(root.get("type"), "%".concat(filter.getType()).concat("%")));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
