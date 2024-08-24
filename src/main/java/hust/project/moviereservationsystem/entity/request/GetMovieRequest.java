package hust.project.moviereservationsystem.entity.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMovieRequest {
    public Long page;
    public Long pageSize;
    private String title;
    private LocalDate releaseDate;
    private String language;
    private String genre;
}
