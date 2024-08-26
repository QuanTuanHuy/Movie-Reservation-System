package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.entity.request.CreateSeatTypeRequest;
import hust.project.moviereservationsystem.model.SeatTypeModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SeatTypeMapper {
    public abstract SeatTypeModel toModelFromEntity(SeatTypeEntity entity);

    public abstract SeatTypeEntity toEntityFromModel(SeatTypeModel model);

    public abstract SeatTypeEntity toEntityFromRequest(CreateSeatTypeRequest request);

    public abstract List<SeatTypeEntity> toEntitiesFromModels(List<SeatTypeModel> models);
}
