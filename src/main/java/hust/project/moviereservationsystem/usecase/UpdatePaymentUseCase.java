package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.constant.BookingStatus;
import hust.project.moviereservationsystem.constant.PaymentStatus;
import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.exception.UpdatePaymentException;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.IPaymentPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UpdatePaymentUseCase {
    private final IPaymentPort paymentPort;
    private final IBookingPort bookingPort;
    private final UpdateBookingUseCase updateBookingUseCase;

    public PaymentEntity updatePaymentStatus(Long paymentId, String status) {
        PaymentEntity payment = paymentPort.getPaymentById(paymentId);

        if (!validatePaymentStatus(payment.getStatus(), status)) {
            log.error("[UpdatePaymentUseCase] Invalid payment status transition");
            throw new UpdatePaymentException();
        }

        BookingEntity booking = bookingPort.getBookingById(payment.getBookingId());

        if (status.equals(PaymentStatus.COMPLETED.name())) {
            payment.setStatus(PaymentStatus.COMPLETED.name());
            booking.setStatus(BookingStatus.COMPLETED.name());
            bookingPort.save(booking);
        } else if (status.equals(PaymentStatus.FAILED.name())) {
            payment.setStatus(PaymentStatus.FAILED.name());
            updateBookingUseCase.cancelBooking(booking.getId(), booking.getUserId());
        }

        return paymentPort.save(payment);
    }

    public boolean validatePaymentStatus(String oldStatus, String newStatus) {
        return (oldStatus.equals(PaymentStatus.PENDING.name()) && newStatus.equals(PaymentStatus.COMPLETED.name()))
            || (oldStatus.equals(PaymentStatus.PENDING.name()) && newStatus.equals(PaymentStatus.FAILED.name()));
    }
}
