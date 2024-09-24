package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.entity.response.CommentOnMovieGetDetailResponse;
import hust.project.moviereservationsystem.entity.response.CommentOnMovieGetResponse;
import hust.project.moviereservationsystem.entity.response.PageResponse;
import hust.project.moviereservationsystem.port.ICommentOnMoviePort;
import hust.project.moviereservationsystem.port.IUserPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCommentOnMovieUseCase {
    private final ICommentOnMoviePort commentOnMoviePort;
    private final IUserPort userPort;

    public PageResponse<CommentOnMovieGetResponse> getCommentByMovieId(Long movieId, Integer page, Integer pageSize) {
        var pairComments = commentOnMoviePort.getCommentsByMovieId(movieId, page, pageSize);

        var userIds = pairComments.getSecond().stream()
                .map(CommentOnMovieEntity::getUserId)
                .toList();
        var userEntities = userPort.getUsersByIds(userIds);

        HashMap<Long, String> mIdToName = (HashMap<Long, String>) userEntities.stream()
                .collect(Collectors.toMap(UserEntity::getId,
                        userEntity -> userEntity.getFirstName() + " " + userEntity.getLastName()));

        var pageInfo = pairComments.getFirst();
        var commentList = pairComments.getSecond().stream()
                .map(commentEntity -> CommentOnMovieGetResponse.builder()
                        .id(commentEntity.getId())
                        .content(commentEntity.getContent())
                        .userId(commentEntity.getUserId())
                        .userFullName(mIdToName.get(commentEntity.getUserId()))
                        .createdOn(commentEntity.getCreatedOn())
                        .lastModifiedOn(commentEntity.getLastModifiedOn())
                        .build())
                .toList();

        return PageResponse.<CommentOnMovieGetResponse>builder()
                .totalPage(pageInfo.getTotalPage())
                .totalRecord(pageInfo.getTotalRecord())
                .previousPage(pageInfo.getPreviousPage())
                .nextPage(pageInfo.getNextPage())
                .data(commentList)
                .build();

    }

    public CommentOnMovieGetDetailResponse getCommentOnMovieDetail(Long id) {
        var parentComment = commentOnMoviePort.getById(id);
        if (parentComment == null) {
            return null;
        }

        var commentEntities = commentOnMoviePort.getCommentsByAncestorIdAndLeftAndRight(
                parentComment.getAncestorId(), parentComment.getLft(), parentComment.getRgt());

        var userEntities = userPort.getUsersByIds(commentEntities.stream()
                .map(CommentOnMovieEntity::getUserId)
                .toList());

        HashMap<Long, String> mIdToName = (HashMap<Long, String>) userEntities.stream()
                .collect(Collectors.toMap(UserEntity::getId,
                        userEntity -> userEntity.getFirstName() + " " + userEntity.getLastName()));

        HashMap<Long, CommentOnMovieGetDetailResponse> mIdToCommentDetail = new HashMap<>();

        // comment are sorted by left value
        for (var commentEntity : commentEntities) {
            var currentComment = CommentOnMovieGetDetailResponse.builder()
                    .id(commentEntity.getId())
                    .content(commentEntity.getContent())
                    .userId(commentEntity.getUserId())
                    .userFullName(mIdToName.get(commentEntity.getUserId()))
                    .createdOn(commentEntity.getCreatedOn())
                    .lastModifiedOn(commentEntity.getLastModifiedOn())
                    .build();

            if (mIdToCommentDetail.containsKey(commentEntity.getParentId())) {
                mIdToCommentDetail.get(commentEntity.getParentId()).getChildren().add(currentComment);
            }

            mIdToCommentDetail.put(currentComment.getId(), currentComment);
        }

        return mIdToCommentDetail.get(id);
    }
}
