package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.CommentOnMovieEntity;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.exception.CreateCommentOnMovieException;
import hust.project.moviereservationsystem.exception.UpdateCommentOnMovieException;
import hust.project.moviereservationsystem.mapper.CommentOnMovieMapper;
import hust.project.moviereservationsystem.model.CommentOnMovieModel;
import hust.project.moviereservationsystem.port.ICommentOnMoviePort;
import hust.project.moviereservationsystem.repository.ICommentOnMovieRepository;
import hust.project.moviereservationsystem.utils.PageInfoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentOnMovieAdapter implements ICommentOnMoviePort {
    private final ICommentOnMovieRepository commentOnMovieRepository;
    private final CommentOnMovieMapper commentOnMovieMapper;

    @Override
    public CommentOnMovieEntity save(CommentOnMovieEntity commentOnMovieEntity) {
        try {
            CommentOnMovieModel commentOnMovieModel = commentOnMovieMapper.toModelFromEntity(commentOnMovieEntity);
            return commentOnMovieMapper.toEntityFromModel(commentOnMovieRepository.save(commentOnMovieModel));
        } catch (Exception e) {
            log.error("[CommentOnMovieAdapter][save] error: {}", e.getMessage());
            throw new CreateCommentOnMovieException();
        }
    }

    @Override
    public CommentOnMovieEntity getById(Long id) {
        return commentOnMovieMapper.toEntityFromModel(commentOnMovieRepository.findById(id).orElse(null));
    }

    @Override
    public Pair<PageInfo, List<CommentOnMovieEntity>> getCommentsByMovieId(Long movieId, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("createdOn").descending());

        Page<CommentOnMovieModel> pageComment = commentOnMovieRepository.findByMovieIdAndParentIdIsNull(movieId, pageable);
        PageInfo pageInfo = PageInfoUtils.getPageInfo(pageComment);
        return Pair.of(pageInfo,
                pageComment.getContent().stream().map(commentOnMovieMapper::toEntityFromModel).toList());
    }

    @Override
    public void updateCommentOnMovieSetLeft(Long parentRight, Long ancestorId) {
        try {
            commentOnMovieRepository.updateCommentOnMovieSetLeft(parentRight, ancestorId);
        } catch (Exception e) {
            throw new UpdateCommentOnMovieException();
        }
    }

    @Override
    public void updateCommentOnMovieSetRight(Long parentRight, Long ancestorId) {
        try {
            commentOnMovieRepository.updateCommentOnMovieSetRight(parentRight, ancestorId);
        } catch (Exception e) {
            throw new UpdateCommentOnMovieException();
        }
    }

    @Override
    public void deleteByAncestorId(Long ancestorId) {
        commentOnMovieRepository.deleteByAncestorId(ancestorId);
    }

    @Override
    public List<CommentOnMovieEntity> getCommentsByAncestorIdAndLeftAndRight(Long ancestorId, Long lft, Long rgt) {
        return commentOnMovieRepository.findByAncestorIdAndLeftAndRight(ancestorId, lft, rgt)
                .stream().map(commentOnMovieMapper::toEntityFromModel)
                .toList();
    }
}
