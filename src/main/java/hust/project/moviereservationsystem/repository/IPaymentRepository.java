package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.PaymentModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPaymentRepository extends IBaseRepository<PaymentModel> {
    Optional<PaymentModel> findByBookingId(Long bookingId);

    List<PaymentModel> findByBookingIdIn(List<Long> bookingIds);
}
