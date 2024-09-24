package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateCommentOnMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCommentOnMovieRequest;
import hust.project.moviereservationsystem.entity.response.CommentOnMovieGetDetailResponse;
import hust.project.moviereservationsystem.entity.response.CommentOnMovieGetResponse;
import hust.project.moviereservationsystem.entity.response.PageResponse;


public interface ICommentOnMovieService {
    CommentOnMovieEntity createCommentOnMovie(CreateCommentOnMovieRequest request);

    CommentOnMovieGetDetailResponse getCommentOnMovieDetail(Long id);

    CommentOnMovieEntity updateCommentOnMovie(Long id, UpdateCommentOnMovieRequest request);

    void deleteCommentOnMovie(Long userId, Long id);

    PageResponse<CommentOnMovieGetResponse> getCommentByMovieId(Long movieId, Integer page, Integer pageSize);
}
