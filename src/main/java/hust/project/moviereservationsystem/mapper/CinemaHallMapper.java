package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallRequest;
import hust.project.moviereservationsystem.model.CinemaHallModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CinemaHallMapper {
    public abstract CinemaHallEntity toEntityFromModel(CinemaHallModel model);

    public abstract CinemaHallModel toModelFromEntity(CinemaHallEntity entity);

    public abstract List<CinemaHallEntity> toEntitiesFromModels(List<CinemaHallModel> models);

    public abstract CinemaHallEntity toEntityFromRequest(CreateCinemaHallRequest request);
}
