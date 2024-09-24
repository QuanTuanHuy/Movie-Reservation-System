package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentOnMovieEntity {
    private Long id;

    private Long movieId;

    private Long userId;

    private String content;

    private Long parentId;

    private Long ancestorId;

    private Long lft;

    private Long rgt;

    private LocalDateTime createdOn;

    private LocalDateTime lastModifiedOn;
}
