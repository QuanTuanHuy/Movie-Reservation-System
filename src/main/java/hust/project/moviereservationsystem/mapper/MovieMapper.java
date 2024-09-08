package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateMovieRequest;
import hust.project.moviereservationsystem.model.MovieModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    public abstract MovieEntity toEntityFromModel(MovieModel model);

    public abstract MovieModel toModelFromEntity(MovieEntity entity);

    public abstract List<MovieEntity> toEntitiesFromModels(List<MovieModel> models);

    public abstract MovieEntity toEntityFromRequest(CreateMovieRequest request);

    public abstract MovieEntity toEntityFromRequest(UpdateMovieRequest request);
}
