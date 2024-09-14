package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.GetPromotionRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IPromotionPort {
    PromotionEntity save(PromotionEntity promotion);

    Pair<PageInfo, List<PromotionEntity>> getAllPromotions(GetPromotionRequest filter);

    PromotionEntity getById(Long id);

    PromotionEntity getByCode(String code);
}
