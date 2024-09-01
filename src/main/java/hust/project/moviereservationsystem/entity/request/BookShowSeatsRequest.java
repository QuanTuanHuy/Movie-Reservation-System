package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookShowSeatsRequest {
    List<Long> showSeatIds;
}
