package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.BookingModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBookingRepository extends IBaseRepository<BookingModel> {
    List<BookingModel> findByUserId(Long userId);

    List<BookingModel> findByShowIdIn(List<Long> showIds);

    Optional<BookingModel> findByPaymentId(Long paymentId);
}
