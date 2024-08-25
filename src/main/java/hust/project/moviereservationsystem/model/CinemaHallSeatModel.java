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
@Entity(name = "Cinema Hall Seat Model")
@Table(name = "cinema_hall_seats")
public class CinemaHallSeatModel extends BaseModel {
    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "cinema_hall_id")
    private Long cinemaHallId;
}
