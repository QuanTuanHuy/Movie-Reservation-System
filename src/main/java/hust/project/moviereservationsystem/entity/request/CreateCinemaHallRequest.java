package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCinemaHallRequest {
    private String name;
    private Long totalSeats;
    private String image;
    private String type;

    private Long cinemaId;
    private String cinemaName;
}
