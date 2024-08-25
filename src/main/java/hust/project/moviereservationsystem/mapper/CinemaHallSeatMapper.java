package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.model.CinemaHallSeatModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CinemaHallSeatMapper {
    public abstract CinemaHallSeatEntity toEntityFromModel(CinemaHallSeatModel model);

    public abstract CinemaHallSeatModel toModelFromEntity(CinemaHallSeatEntity entity);

    public abstract List<CinemaHallSeatEntity> toEntitiesFromModels(List<CinemaHallSeatModel> models);

    public abstract CinemaHallSeatEntity toEntityFromRequest(CreateCinemaHallSeatRequest request);
}
