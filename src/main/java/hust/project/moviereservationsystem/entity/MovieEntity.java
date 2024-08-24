package hust.project.moviereservationsystem.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity extends BaseEntity {
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

    List<GenreEntity> genres = new ArrayList<>();
}
