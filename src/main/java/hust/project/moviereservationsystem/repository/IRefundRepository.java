package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.RefundModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRefundRepository extends IBaseRepository<RefundModel> {
    Optional<RefundModel> findByBookingId(Long bookingId);
}
