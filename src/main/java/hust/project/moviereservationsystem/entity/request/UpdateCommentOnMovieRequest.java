package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentOnMovieRequest {
    private Long userId;
    private String content;
}
