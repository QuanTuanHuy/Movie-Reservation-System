package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UpdateMovieRequest {
    private String title;
    private String description;
    private Long duration;
    private LocalDate releaseDate;
    private String language;
    private String country;
    private String actors;
    private String director;
    private String bannerImg;
    private String trailer;
    private Long ageLimit;
    List<Long> genreIds;
}
