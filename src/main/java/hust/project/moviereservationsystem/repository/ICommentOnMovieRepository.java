package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.CommentOnMovieModel;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentOnMovieRepository extends IBaseRepository<CommentOnMovieModel> {
    Page<CommentOnMovieModel> findByMovieIdAndParentIdIsNull(Long movieId, Pageable pageable);

    @Query(value = "SELECT c FROM CommentOnMovieModel c WHERE c.ancestorId = :ancestorId AND c.lft >= :lft AND c.rgt <= :rgt ORDER BY c.lft")
    List<CommentOnMovieModel> findByAncestorIdAndLeftAndRight(
            @Param("ancestorId") Long ancestorId,
            @Param("left") Long lft,
            @Param("right") Long rgt);

    void deleteByAncestorId(Long ancestorId);

    @Modifying
    @Query(value = "UPDATE CommentOnMovieModel c SET c.lft = c.lft + 2 WHERE c.lft > :parentRight AND c.ancestorId = :ancestorId")
    void updateCommentOnMovieSetLeft(@Param("parentRight") Long parentRight, @Param("ancestorId") Long ancestorId);

    @Modifying
    @Query(value = "UPDATE CommentOnMovieModel c SET c.rgt = c.rgt + 2 WHERE c.rgt >= :parentRight AND c.ancestorId = :ancestorId")
    void updateCommentOnMovieSetRight(@Param("parentRight") Long parentRight, @Param("ancestorId") Long ancestorId);
}
