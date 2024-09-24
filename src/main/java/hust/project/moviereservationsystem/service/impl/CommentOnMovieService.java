package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateCommentOnMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCommentOnMovieRequest;
import hust.project.moviereservationsystem.entity.response.CommentOnMovieGetDetailResponse;
import hust.project.moviereservationsystem.entity.response.CommentOnMovieGetResponse;
import hust.project.moviereservationsystem.entity.response.PageResponse;
import hust.project.moviereservationsystem.service.ICommentOnMovieService;
import hust.project.moviereservationsystem.usecase.CreateCommentOnMovieUseCase;
import hust.project.moviereservationsystem.usecase.DeleteCommentUseCase;
import hust.project.moviereservationsystem.usecase.GetCommentOnMovieUseCase;
import hust.project.moviereservationsystem.usecase.UpdateCommentOnMovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentOnMovieService implements ICommentOnMovieService {
    private final CreateCommentOnMovieUseCase createCommentOnMovieUseCase;
    private final GetCommentOnMovieUseCase getCommentOnMovieUseCase;
    private final UpdateCommentOnMovieUseCase updateCommentOnMovieUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    @Override
    public CommentOnMovieEntity createCommentOnMovie(CreateCommentOnMovieRequest request) {
        return createCommentOnMovieUseCase.createCommentOnMovie(request);
    }

    @Override
    public CommentOnMovieGetDetailResponse getCommentOnMovieDetail(Long id) {
        return getCommentOnMovieUseCase.getCommentOnMovieDetail(id);
    }

    @Override
    public CommentOnMovieEntity updateCommentOnMovie(Long id, UpdateCommentOnMovieRequest request) {
        return updateCommentOnMovieUseCase.updateCommentOnMovie(id, request);
    }

    @Override
    public void deleteCommentOnMovie(Long userId, Long id) {
        deleteCommentUseCase.deleteCommentOnMovie(userId, id);
    }

    @Override
    public PageResponse<CommentOnMovieGetResponse> getCommentByMovieId(
            Long movieId, Integer page, Integer pageSize) {
        return getCommentOnMovieUseCase.getCommentByMovieId(movieId, page, pageSize);
    }
}
