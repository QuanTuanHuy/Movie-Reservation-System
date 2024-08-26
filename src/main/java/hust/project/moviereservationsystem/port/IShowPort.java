package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.GetShowRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IShowPort {
    ShowEntity save(ShowEntity showEntity);

    List<ShowEntity> getAllShows(GetShowRequest filter);

    List<ShowEntity> getShowsByCinemaHallIdIn(List<Long> cinemaHallIds);

    List<ShowEntity> getShowsByCinemaHallIdsAndDate(List<Long> cinemaHallIds, LocalDate date);

    ShowEntity getShowById(Long id);

    void deleteShowById(Long id);

    boolean existsByCinemaHallIdAndInternalTime(Long cinemaHallId, LocalDateTime internalTIme);
}
