package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateGenreRequest;
import hust.project.moviereservationsystem.model.GenreModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GenreMapper {
    public abstract GenreModel toModelFromEntity(GenreEntity entity);

    public abstract GenreEntity toEntityFromModel(GenreModel model);

    public abstract GenreEntity toEntityFromRequest(CreateGenreRequest request);

    public abstract List<GenreEntity> toEntitiesFromModels(List<GenreModel> models);
}
