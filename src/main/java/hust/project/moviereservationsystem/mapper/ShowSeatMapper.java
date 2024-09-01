package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.model.ShowSeatModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ShowSeatMapper {
    public abstract ShowSeatEntity toEntityFromModel(ShowSeatModel model);

    public abstract ShowSeatModel toModelFromEntity(ShowSeatEntity entity);

    public abstract List<ShowSeatEntity> toEntitiesFromModels(List<ShowSeatModel> models);

    public abstract List<ShowSeatModel> toModelsFromEntities(List<ShowSeatEntity> entities);
}
