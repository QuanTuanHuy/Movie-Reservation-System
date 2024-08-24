package hust.project.moviereservationsystem.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieGenreEntity extends BaseEntity {
    private Long movieId;
    private Long genreId;
}
