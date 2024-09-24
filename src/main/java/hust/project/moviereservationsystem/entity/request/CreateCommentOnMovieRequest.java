package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentOnMovieRequest {
    private Long movieId;
    private Long userId;
    private String content;
    private Long parentId;
}
