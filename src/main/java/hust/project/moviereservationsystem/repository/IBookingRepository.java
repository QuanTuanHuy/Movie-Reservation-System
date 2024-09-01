package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.BookingModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepository extends IBaseRepository<BookingModel> {
    List<BookingModel> findByUserId(Long userId);
}
