package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.ShowSeatModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShowSeatRepository extends IBaseRepository<ShowSeatModel> {
    List<ShowSeatModel> findByShowId(Long showId);

    List<ShowSeatModel> findByBookingId(Long bookingId);

    List<ShowSeatModel> findByUserIdAndBookingIdIsNull(Long userId);

    List<ShowSeatModel> findByIdIn(List<Long> ids);

    void deleteAllByShowId(Long showId);
}
