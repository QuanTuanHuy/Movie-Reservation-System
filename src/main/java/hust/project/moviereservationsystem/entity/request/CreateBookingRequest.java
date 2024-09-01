package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequest {
    List<Long> showSeatIds;
    private String paymentMethod;
    private Long showId;
    private String note;
}
