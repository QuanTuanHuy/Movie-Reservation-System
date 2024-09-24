package hust.project.moviereservationsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment_on_movies")
public class CommentOnMovieModel extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "content")
    private String content;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "ancestor_id")
    private Long ancestorId;

    @Column(name = "lft")
    private Long lft;

    @Column(name = "rgt")
    private Long rgt;
}
