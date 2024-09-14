package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.RefundEntity;

public interface IRefundPort {
    RefundEntity save(RefundEntity refundEntity);

    RefundEntity getById(Long id);

    RefundEntity getByBookingId(Long bookingId);
}
