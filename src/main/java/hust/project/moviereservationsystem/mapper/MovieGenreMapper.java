package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.MovieGenreEntity;
import hust.project.moviereservationsystem.model.MovieGenreModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MovieGenreMapper {
    public abstract MovieGenreModel toModelFromEntity(MovieGenreEntity entity);

    public abstract MovieGenreEntity toEntityFromModel(MovieGenreModel model);

    public abstract List<MovieGenreModel> toModelsFromEntities(List<MovieGenreEntity> entities);

    public abstract List<MovieGenreEntity> toEntitiesFromModels(List<MovieGenreModel> models);
}
