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
@Entity(name = "Cinema Hall Model")
@Table(name = "cinema_halls")
public class CinemaHallModel extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "total_seats")
    private Long totalSeats;

    @Column(name = "image")
    private String image;

    @Column(name = "type")
    private String type;

    @Column(name = "cinema_id")
    private Long cinemaId;
}
