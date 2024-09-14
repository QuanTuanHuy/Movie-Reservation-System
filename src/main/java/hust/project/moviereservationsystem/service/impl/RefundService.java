package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.RefundEntity;
import hust.project.moviereservationsystem.entity.request.CreateRefundRequest;
import hust.project.moviereservationsystem.service.IRefundService;
import hust.project.moviereservationsystem.usecase.CreateRefundUseCase;
import hust.project.moviereservationsystem.usecase.UpdateRefundUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefundService implements IRefundService {
    private final CreateRefundUseCase createRefundUseCase;
    private final UpdateRefundUseCase updateRefundUseCase;

    @Override
    public RefundEntity createRefund(CreateRefundRequest request, Long useId) {
        return createRefundUseCase.createRefund(request, useId);
    }

    @Override
    public RefundEntity updateRefundStatus(Long refundId, String status) {
        return updateRefundUseCase.updateRefundStatus(refundId, status);
    }
}
