package hust.project.moviereservationsystem.entity.response;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.ShowEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllShowsItemResponse {
    private CinemaEntity cinema;
    private List<ShowEntity> shows;
}
