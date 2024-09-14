package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.CreatePromotionRequest;
import hust.project.moviereservationsystem.entity.request.GetPromotionRequest;
import hust.project.moviereservationsystem.entity.request.UpdatePromotionRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.IPromotionService;
import hust.project.moviereservationsystem.usecase.CreatePromotionUseCase;
import hust.project.moviereservationsystem.usecase.GetPromotionUseCase;
import hust.project.moviereservationsystem.usecase.UpdatePromotionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService implements IPromotionService {
    private final CreatePromotionUseCase createPromotionUseCase;
    private final GetPromotionUseCase getPromotionUseCase;
    private final UpdatePromotionUseCase updatePromotionUseCase;

    @Override
    public PromotionEntity createPromotion(CreatePromotionRequest request) {
        return createPromotionUseCase.createPromotion(request);
    }

    @Override
    public Pair<PageInfo, List<PromotionEntity>> getAllPromotions(GetPromotionRequest filter) {
        return getPromotionUseCase.getAllPromotions(filter);
    }

    @Override
    public PromotionEntity updatePromotion(Long id, UpdatePromotionRequest request) {
        return updatePromotionUseCase.updatePromotion(id, request);
    }

    @Override
    public PromotionEntity getPromotionByCode(String code) {
        return getPromotionUseCase.getPromotionByCode(code);
    }
}
