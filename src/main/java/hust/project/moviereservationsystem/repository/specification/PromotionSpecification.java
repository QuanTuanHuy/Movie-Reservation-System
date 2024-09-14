package hust.project.moviereservationsystem.repository.specification;

import hust.project.moviereservationsystem.entity.request.GetPromotionRequest;
import hust.project.moviereservationsystem.model.PromotionModel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PromotionSpecification {
    public static Specification<PromotionModel> getAll(GetPromotionRequest filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(filter.getName())) {
                predicates.add(builder.like(root.get("name"), "%".concat(filter.getName()).concat("%")));
            }
            if (StringUtils.hasText(filter.getDescription())) {
                predicates.add(builder.like(root.get("description"), "%".concat(filter.getDescription()).concat("%")));
            }


            predicates.add(builder.greaterThanOrEqualTo(root.get("endTime"), LocalDateTime.now()));
            predicates.add(builder.equal(root.get("isActive"), true));

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
