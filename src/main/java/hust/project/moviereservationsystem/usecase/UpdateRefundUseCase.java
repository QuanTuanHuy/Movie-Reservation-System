package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.constant.RefundStatus;
import hust.project.moviereservationsystem.entity.RefundEntity;
import hust.project.moviereservationsystem.port.IRefundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateRefundUseCase {
    private final IRefundPort refundPort;

    public RefundEntity updateRefundStatus(Long refundId, String status) {
        RefundEntity refund = refundPort.getById(refundId);
        refund.setRefundStatus(RefundStatus.valueOf(status.toUpperCase()).name());
        return refundPort.save(refund);
    }
}
