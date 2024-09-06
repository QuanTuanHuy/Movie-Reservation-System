package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRatingRequest {
    private Long movieId;
    private Long ratingStar;
    private String content;
}
