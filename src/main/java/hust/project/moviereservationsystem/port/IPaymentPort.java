package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.PaymentEntity;

import java.util.List;

public interface IPaymentPort {
    PaymentEntity save(PaymentEntity paymentEntity);

    PaymentEntity getPaymentById(Long id);

    PaymentEntity getPaymentByBookingId(Long bookingId);

    List<PaymentEntity> getPaymentsByBookingIds(List<Long> bookingIds);
}
