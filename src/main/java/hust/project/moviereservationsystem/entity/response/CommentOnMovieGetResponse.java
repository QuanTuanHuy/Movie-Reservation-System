package hust.project.moviereservationsystem.entity.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentOnMovieGetResponse {
    private Long id;
    private String content;
    private Long userId;
    private String userFullName;
    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;
}
