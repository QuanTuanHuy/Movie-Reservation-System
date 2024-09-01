package hust.project.moviereservationsystem.entity.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCinemaHallSeatRequest {
    private Long page;
    private Long pageSize;
    private String type;
    private Long cinemaHallId;
}
