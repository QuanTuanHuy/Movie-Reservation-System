package hust.project.moviereservationsystem.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllShowsResponse {
    private Long totalCinema;
    private List<AllShowsItemResponse> cinemaShows;
}
