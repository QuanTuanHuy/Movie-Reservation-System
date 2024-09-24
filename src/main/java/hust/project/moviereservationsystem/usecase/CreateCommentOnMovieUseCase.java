package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateCommentOnMovieRequest;
import hust.project.moviereservationsystem.exception.CreateCommentOnMovieException;
import hust.project.moviereservationsystem.mapper.CommentOnMovieMapper;
import hust.project.moviereservationsystem.port.ICommentOnMoviePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CreateCommentOnMovieUseCase {
    private final ICommentOnMoviePort commentOnMoviePort;
    private final CommentOnMovieMapper commentOnMovieMapper;

    public CommentOnMovieEntity createCommentOnMovie(CreateCommentOnMovieRequest request) {
        CommentOnMovieEntity commentOnMovieEntity = commentOnMovieMapper.toEntityFromRequest(request);

        CommentOnMovieEntity parentComment = null;
        if (request.getParentId() != null) {
            parentComment = commentOnMoviePort.getById(request.getParentId());
        }

        if (parentComment != null) {
            if (!parentComment.getMovieId().equals(commentOnMovieEntity.getMovieId())) {
                log.error("[CreateCommentOnMovieUseCase] error: parent comment is not belong to this movie");
                throw new CreateCommentOnMovieException();
            }

            commentOnMovieEntity.setLft(parentComment.getRgt());
            commentOnMovieEntity.setRgt(parentComment.getRgt() + 1);
            commentOnMovieEntity.setAncestorId(parentComment.getAncestorId());

            commentOnMoviePort.updateCommentOnMovieSetRight(parentComment.getRgt(), parentComment.getAncestorId());
            commentOnMoviePort.updateCommentOnMovieSetLeft(parentComment.getRgt(), parentComment.getAncestorId());
        } else {
            commentOnMovieEntity.setLft(1L);
            commentOnMovieEntity.setRgt(2L);
        }

        CommentOnMovieEntity savedComment =  commentOnMoviePort.save(commentOnMovieEntity);
        if (parentComment == null) {
            savedComment.setAncestorId(savedComment.getId());
        }

        return commentOnMoviePort.save(savedComment);
    }
}
