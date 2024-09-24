package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateCommentOnMovieRequest;
import hust.project.moviereservationsystem.model.CommentOnMovieModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CommentOnMovieMapper {
    public abstract CommentOnMovieEntity toEntityFromRequest(CreateCommentOnMovieRequest request);

    public abstract CommentOnMovieEntity toEntityFromModel(CommentOnMovieModel model);

    public abstract CommentOnMovieModel toModelFromEntity(CommentOnMovieEntity entity);
}
