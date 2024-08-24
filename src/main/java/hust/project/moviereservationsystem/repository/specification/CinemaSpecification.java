package hust.project.moviereservationsystem.repository.specification;

import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.model.CinemaModel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class CinemaSpecification {
    public static Specification<CinemaModel> getAllCinemas(GetCinemaRequest filter) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (filter.getCityCode() != null) {
                predicates.add(builder.and(builder.equal(root.get("cityCode"), filter.getCityCode())));
            }
            if (filter.getName() != null) {
                predicates.add(builder.and(builder.like(root.get("name"), "%".concat(filter.getName()).concat("%"))));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
