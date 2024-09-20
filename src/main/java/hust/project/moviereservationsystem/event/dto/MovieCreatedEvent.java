package hust.project.moviereservationsystem.event.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieCreatedEvent {
    private Long movieId;
}
