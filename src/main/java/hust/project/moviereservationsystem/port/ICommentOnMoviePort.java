package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ICommentOnMoviePort {
    CommentOnMovieEntity save(CommentOnMovieEntity commentOnMovieEntity);

    CommentOnMovieEntity getById(Long id);

    Pair<PageInfo, List<CommentOnMovieEntity>> getCommentsByMovieId(Long movieId, Integer page, Integer pageSize);

    void updateCommentOnMovieSetLeft(Long parentRight, Long ancestorId);

    void updateCommentOnMovieSetRight(Long parentRight, Long ancestorId);

    void deleteByAncestorId(Long ancestorId);

    List<CommentOnMovieEntity> getCommentsByAncestorIdAndLeftAndRight(Long parentId, Long lft, Long rgt);
}
