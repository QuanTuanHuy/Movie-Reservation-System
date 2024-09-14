package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.GetPromotionRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.port.IPromotionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPromotionUseCase {
    private final IPromotionPort promotionPort;

    public Pair<PageInfo, List<PromotionEntity>> getAllPromotions(GetPromotionRequest filter) {
        return promotionPort.getAllPromotions(filter);
    }

    public PromotionEntity getPromotionByCode(String code) {
        return promotionPort.getByCode(code);
    }
}
