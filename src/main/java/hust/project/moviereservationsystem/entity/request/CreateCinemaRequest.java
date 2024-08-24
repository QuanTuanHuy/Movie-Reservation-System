package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCinemaRequest {
    private String name;
    private Long totalCinemaHalls;
    private String phoneNumber;

    private CreateAddressRequest address;
}
