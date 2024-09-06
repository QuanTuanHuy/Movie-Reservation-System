package hust.project.moviereservationsystem.entity.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticResponse {
    private Long revenue;
    private Long totalTickets;
}
