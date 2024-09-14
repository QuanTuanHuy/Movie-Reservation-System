package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.PromotionModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPromotionRepository extends IBaseRepository<PromotionModel> {
    Optional<PromotionModel> findByCode(String code);
}
