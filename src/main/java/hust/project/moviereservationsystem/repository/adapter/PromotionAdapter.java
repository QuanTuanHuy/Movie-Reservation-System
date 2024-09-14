package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.GetPromotionRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.exception.CreatePromotionException;
import hust.project.moviereservationsystem.exception.GetPromotionException;
import hust.project.moviereservationsystem.mapper.PromotionMapper;
import hust.project.moviereservationsystem.model.PromotionModel;
import hust.project.moviereservationsystem.port.IPromotionPort;
import hust.project.moviereservationsystem.repository.IPromotionRepository;
import hust.project.moviereservationsystem.repository.specification.PromotionSpecification;
import hust.project.moviereservationsystem.utils.PageInfoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionAdapter implements IPromotionPort {
    private final IPromotionRepository promotionRepository;
    private final PromotionMapper promotionMapper;

    @Override
    public PromotionEntity save(PromotionEntity promotion) {
        try {
            PromotionModel promotionModel = promotionMapper.toModelFromEntity(promotion);
            return promotionMapper.toEntityFromModel(promotionRepository.save(promotionModel));
        } catch (Exception e) {
            throw new CreatePromotionException();
        }
    }

    @Override
    public Pair<PageInfo, List<PromotionEntity>> getAllPromotions(GetPromotionRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").ascending());

        Page<PromotionModel> pagePromotion = promotionRepository.findAll(PromotionSpecification.getAll(filter), pageable);

        PageInfo pageInfo = PageInfoUtils.getPageInfo(pagePromotion);

        return Pair.of(pageInfo, promotionMapper.toEntitiesFromModels(pagePromotion.getContent()));
    }

    @Override
    public PromotionEntity getById(Long id) {
        return promotionMapper.toEntityFromModel(promotionRepository.findById(id)
                .orElseThrow(GetPromotionException::new));
    }

    @Override
    public PromotionEntity getByCode(String code) {
        return promotionMapper.toEntityFromModel(promotionRepository.findByCode(code)
                .orElseThrow(GetPromotionException::new));
    }
}
