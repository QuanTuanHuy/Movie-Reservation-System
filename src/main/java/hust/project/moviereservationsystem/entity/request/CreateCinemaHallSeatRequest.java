package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCinemaHallSeatRequest {
    private String code;
    private String type;
    private Long cinemaHallId;
}
