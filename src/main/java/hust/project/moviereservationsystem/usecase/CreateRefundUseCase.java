package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.constant.PaymentStatus;
import hust.project.moviereservationsystem.constant.RefundStatus;
import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.entity.RefundEntity;
import hust.project.moviereservationsystem.entity.request.CreateRefundRequest;
import hust.project.moviereservationsystem.exception.CreateRefundException;
import hust.project.moviereservationsystem.mapper.RefundMapper;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.port.IPaymentPort;
import hust.project.moviereservationsystem.port.IRefundPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CreateRefundUseCase {
    private final IRefundPort refundPort;
    private final IBookingPort bookingPort;
    private final IPaymentPort paymentPort;
    private final RefundMapper refundMapper;

    public RefundEntity createRefund(CreateRefundRequest request, Long userId) {
        if (!StringUtils.hasText(request.getCardNumber()) || !StringUtils.hasText(request.getBankName())) {
            log.error("[CreateRefundUseCase] Invalid request");
            throw new CreateRefundException();
        }

        RefundEntity existedRefund = refundPort.getByBookingId(request.getBookingId());
        if (existedRefund != null) {
            log.error("[CreateRefundUseCase] Refund existed");
            throw new CreateRefundException();
        }

        BookingEntity booking = bookingPort.getBookingById(request.getBookingId());
        if (!booking.getUserId().equals(userId)) {
            log.error("[CreateRefundUseCase] User does not have permission to create refund");
            throw new CreateRefundException();
        }

        PaymentEntity payment = paymentPort.getPaymentByBookingId(request.getBookingId());
        if (!payment.getStatus().equals(PaymentStatus.COMPLETED.name())) {
            log.error("[CreateRefundUseCase] Payment is not completed");
            throw new CreateRefundException();
        }

        RefundEntity refund = refundMapper.toEntityFromRequest(request);
        refund.setUserId(userId);
        refund.setAmount(payment.getFinalAmount());
        refund.setRefundStatus(RefundStatus.PENDING.name());

        return refundPort.save(refund);

    }
}
