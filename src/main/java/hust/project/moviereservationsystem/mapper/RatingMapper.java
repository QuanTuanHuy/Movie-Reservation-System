package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.RatingEntity;
import hust.project.moviereservationsystem.entity.request.CreateRatingRequest;
import hust.project.moviereservationsystem.model.RatingModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RatingMapper {
    public abstract RatingModel toModelFromEntity(RatingEntity entity);

    public abstract RatingEntity toEntityFromModel(RatingModel model);

    public abstract List<RatingEntity> toEntitiesFromModels(List<RatingModel> models);

    public abstract RatingEntity toEntityFromRequest(CreateRatingRequest request);
}
