package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.model.BookingModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BookingMapper {
    public abstract BookingModel toModelFromEntity(BookingEntity entity);

    public abstract BookingEntity toEntityFromModel(BookingModel model);

    public abstract List<BookingEntity> toEntitiesFromModels(List<BookingModel> models);
}
