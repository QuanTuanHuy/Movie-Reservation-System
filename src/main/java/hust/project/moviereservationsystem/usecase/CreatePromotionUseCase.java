package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.CreatePromotionRequest;
import hust.project.moviereservationsystem.mapper.PromotionMapper;
import hust.project.moviereservationsystem.port.IPromotionPort;
import hust.project.moviereservationsystem.utils.GenerateCodeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePromotionUseCase {
    private final IPromotionPort promotionPort;
    private final PromotionMapper promotionMapper;

    public PromotionEntity createPromotion(CreatePromotionRequest request) {
        PromotionEntity promotion = promotionMapper.toEntityFromRequest(request);
        promotion.setCode(GenerateCodeUtils.generateCode(10));

        return promotionPort.save(promotion);
    }
}
