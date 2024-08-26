package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.CreateShowRequest;
import hust.project.moviereservationsystem.model.ShowModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ShowMapper {
    public abstract ShowModel toModelFromEntity(ShowEntity entity);

    public abstract ShowEntity toEntityFromModel(ShowModel model);

    public abstract ShowEntity toEntityFromRequest(CreateShowRequest request);

    public abstract List<ShowEntity> toEntitiesFromModels(List<ShowModel> models);
}
