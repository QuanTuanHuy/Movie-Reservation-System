package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCinemaRequest {
    private String name;
    private Long totalCinemaHalls;
    private String phoneNumber;
    private Boolean isActive;
}
