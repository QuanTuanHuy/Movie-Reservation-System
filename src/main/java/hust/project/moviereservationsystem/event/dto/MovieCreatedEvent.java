package hust.project.moviereservationsystem.event.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieCreatedEvent {
    private String title;
    private String description;
    private String releaseDate;
    private String movieInfoUrl;
}
