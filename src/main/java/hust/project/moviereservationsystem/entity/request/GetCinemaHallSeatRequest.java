package hust.project.moviereservationsystem.entity.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCinemaHallSeatRequest {
    public Long page;
    public Long pageSize;
    private String type;
    private Long cinemaHallId;
}
