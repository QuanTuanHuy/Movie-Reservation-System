package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCinemaHallSeatRequest {
    private String code;
    private String type;
}
