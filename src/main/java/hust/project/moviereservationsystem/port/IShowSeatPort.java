package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;

import java.util.List;

public interface IShowSeatPort {
    ShowSeatEntity save(ShowSeatEntity showSeatEntity);

    List<ShowSeatEntity> getAllShowSeatsByShowId(Long showId);

    List<ShowSeatEntity> saveAll(List<ShowSeatEntity> showSeatEntities);

    List<ShowSeatEntity> getShowSeatsByBookingId(Long bookingId);

    List<ShowSeatEntity> getShowSeatsByIds(List<Long> ids);

    List<ShowSeatEntity> getShowSeatsByUserId(Long userId);

    ShowSeatEntity getShowSeatById(Long id);

    void deleteShowSeatByShowId(Long showId);
}
