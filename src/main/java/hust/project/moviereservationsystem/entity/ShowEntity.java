package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntity extends BaseEntity {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private MovieEntity movie;
    private CinemaHallEntity cinemaHall;
}
