package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ICinemaHallSeatPort {
    CinemaHallSeatEntity save(CinemaHallSeatEntity cinemaHallSeat);

    Pair<PageInfo, List<CinemaHallSeatEntity>> getAll(GetCinemaHallSeatRequest filter);

    CinemaHallSeatEntity getById(Long id);

    List<CinemaHallSeatEntity> getByCinemaHallId(Long cinemaHallId);

    List<CinemaHallSeatEntity> getByIds(List<Long> ids);

    CinemaHallSeatEntity getByCodeAndCinemaHallId(String code, Long cinemaHallId);
}
