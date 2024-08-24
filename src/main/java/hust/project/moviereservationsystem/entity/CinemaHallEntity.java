package hust.project.moviereservationsystem.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHallEntity extends BaseEntity {
    private String name;
    private Long totalSeats;
    private String image;
    private String type;

    private Long cinemaId;
    private String cinemaName;
}
