package hust.project.moviereservationsystem.entity.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentOnMovieGetDetailResponse {
    private Long id;
    private String content;
    private Long userId;
    private String userFullName;
    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;

    @Builder.Default
    List<CommentOnMovieGetDetailResponse> children = new ArrayList<>();
}
