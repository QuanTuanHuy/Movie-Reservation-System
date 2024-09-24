package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.request.UpdateCommentOnMovieRequest;
import hust.project.moviereservationsystem.exception.UpdateCommentOnMovieException;
import hust.project.moviereservationsystem.port.ICommentOnMoviePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateCommentOnMovieUseCase {
    private final ICommentOnMoviePort commentOnMoviePort;

    public CommentOnMovieEntity updateCommentOnMovie(Long id, UpdateCommentOnMovieRequest request) {
        CommentOnMovieEntity comment = commentOnMoviePort.getById(id);
        if (comment == null || !comment.getUserId().equals(request.getUserId())) {
            log.error("[UpdateCommentOnMovieUseCase] Comment not found, {}", id);
            throw new UpdateCommentOnMovieException();
        }

        if (StringUtils.hasText(request.getContent())) {
            comment.setContent(request.getContent());
        }

        return commentOnMoviePort.save(comment);
    }
}
