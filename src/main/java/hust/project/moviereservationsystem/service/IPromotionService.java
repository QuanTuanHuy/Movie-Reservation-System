package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.CreatePromotionRequest;
import hust.project.moviereservationsystem.entity.request.GetPromotionRequest;
import hust.project.moviereservationsystem.entity.request.UpdatePromotionRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IPromotionService {
    PromotionEntity createPromotion(CreatePromotionRequest request);

    Pair<PageInfo, List<PromotionEntity>> getAllPromotions(GetPromotionRequest filter);

    PromotionEntity updatePromotion(Long id, UpdatePromotionRequest request);

    PromotionEntity getPromotionByCode(String code);
}
