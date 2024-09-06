package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingEntity extends BaseEntity {
    private Long movieId;

    private Long userId;

    private String userName;

    private Long ratingStar;

    private String content;
}
