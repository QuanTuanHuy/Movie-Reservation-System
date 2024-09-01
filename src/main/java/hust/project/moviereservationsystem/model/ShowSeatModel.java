package hust.project.moviereservationsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Show Seat Model")
@Table(name = "show_seats")
public class ShowSeatModel extends BaseModel {
    @Column(name = "show_id")
    private Long showId;

    @Column(name = "cinema_hall_seat_id")
    private Long cinemaHallSeatId;

    @Column(name = "is_reserved")
    private Boolean isReserved;

    @Column(name = "price")
    private Long price;

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "user_id")
    private Long userId;
}
