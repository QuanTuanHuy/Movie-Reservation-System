package hust.project.moviereservationsystem.entity.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetShowRequest {
    private Long movieId;
    private LocalDate date;
}
