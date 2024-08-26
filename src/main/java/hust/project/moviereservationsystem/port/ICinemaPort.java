package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ICinemaPort {
    CinemaEntity save(CinemaEntity cinemaEntity);

    Pair<PageInfo, List<CinemaEntity>> getAllCinemas(GetCinemaRequest filter);

    CinemaEntity getCinemaById(Long cinemaId);

    List<CinemaEntity> getCinemasByIds(List<Long> ids);

    void deleteCinemaById(Long cinemaId);
}
