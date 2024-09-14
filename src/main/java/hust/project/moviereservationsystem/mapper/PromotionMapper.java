package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.CreatePromotionRequest;
import hust.project.moviereservationsystem.model.PromotionModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PromotionMapper {
    public abstract PromotionEntity toEntityFromModel(PromotionModel model);

    public abstract PromotionModel toModelFromEntity(PromotionEntity entity);

    public abstract List<PromotionEntity> toEntitiesFromModels(List<PromotionModel> models);

    public abstract PromotionEntity toEntityFromRequest(CreatePromotionRequest request);
}
