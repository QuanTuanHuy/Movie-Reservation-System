package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.constant.PaymentStatus;
import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.entity.PromotionEntity;
import hust.project.moviereservationsystem.entity.request.CreatePaymentRequest;
import hust.project.moviereservationsystem.exception.CreatePaymentException;
import hust.project.moviereservationsystem.mapper.PaymentMapper;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.IPaymentPort;
import hust.project.moviereservationsystem.port.IPromotionPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreatePaymentUseCase {
    private final IPaymentPort paymentPort;
    private final IPromotionPort promotionPort;
    private final IBookingPort bookingPort;
    private final PaymentMapper paymentMapper;

    @Transactional
    public PaymentEntity createPayment(CreatePaymentRequest request) {
        PaymentEntity payment = paymentMapper.toEntityFromRequest(request);

        BookingEntity booking = bookingPort.getBookingById(request.getBookingId());
        payment.setAmount(booking.getTotalPrice());

        PromotionEntity promotion = promotionPort.getById(request.getPromotionId());
        if (!promotion.getIsActive() || promotion.getStartTime().isAfter(LocalDateTime.now())
            || promotion.getEndTime().isBefore(LocalDateTime.now())) {
            log.error("[CreatePaymentUseCase] Promotion is not valid");
            throw new CreatePaymentException();
        }

        payment.setFinalAmount(booking.getTotalPrice() * (100 - promotion.getDiscountPercentage()) / 100);
        payment.setStatus(PaymentStatus.PENDING.name());

        PaymentEntity savedPayment = paymentPort.save(payment);
        booking.setPaymentId(savedPayment.getId());

        return savedPayment;
    }


}
