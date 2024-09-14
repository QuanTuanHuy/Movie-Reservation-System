package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.UpdatePromotionRequest;
import hust.project.moviereservationsystem.exception.UpdatePromotionException;
import hust.project.moviereservationsystem.port.IPromotionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePromotionUseCase {
    private final IPromotionPort promotionPort;

    public PromotionEntity updatePromotion(Long id, UpdatePromotionRequest request) {
        try {
            PromotionEntity promotion = promotionPort.getById(id);
            promotion.setIsActive(request.getIsActive());
            promotion.setDiscountPercentage(request.getDiscountPercentage());
            promotion.setDescription(request.getDescription());
            promotion.setName(request.getName());
            return promotionPort.save(promotion);
        } catch (Exception e) {
            throw new UpdatePromotionException();
        }
    }
}
