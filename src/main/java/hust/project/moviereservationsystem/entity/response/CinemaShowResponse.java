package hust.project.moviereservationsystem.entity.response;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaShowResponse {
    private CinemaEntity cinema;
    private Long totalMovies;
    private List<CinemaShowItemResponse> movies;
}
