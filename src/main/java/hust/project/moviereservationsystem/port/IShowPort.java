package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.GetShowRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IShowPort {
    ShowEntity save(ShowEntity showEntity);

    List<ShowEntity> getAllShows(GetShowRequest filter);

    List<ShowEntity> getShowsByCinemaHallIdIn(List<Long> cinemaHallIds);

    List<ShowEntity> getShowsByCinemaHallIdsAndDate(List<Long> cinemaHallIds, LocalDate date);

    List<ShowEntity> getShowsByIds(List<Long> ids);

    ShowEntity getShowById(Long id);

    void deleteShowById(Long id);

    boolean existsByCinemaHallIdAndInternalTime(Long cinemaHallId, LocalDateTime internalTIme);
}
