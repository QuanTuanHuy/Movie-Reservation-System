package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaRequest;
import hust.project.moviereservationsystem.model.CinemaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CinemaMapper {
    public abstract CinemaEntity toEntityFromModel(CinemaModel model);

    public abstract CinemaModel toModelFromEntity(CinemaEntity entity);

    public abstract List<CinemaEntity> toEntitiesFromModels(List<CinemaModel> models);

    @Mapping(target = "address", ignore = true)
    public abstract CinemaEntity toEntityFromRequest(CreateCinemaRequest request);
}
