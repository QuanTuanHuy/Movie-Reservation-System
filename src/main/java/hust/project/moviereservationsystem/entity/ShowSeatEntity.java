package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatEntity extends BaseEntity {
    private Long showId;
    private Long cinemaHallSeatId;
    private Boolean isReserved;
    private Long price;
    private Long bookingId;
    private Long userId;
}
