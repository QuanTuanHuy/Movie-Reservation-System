package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSeatTypeRequest {
    private String type;
    private String description;
    private Long price;
}
