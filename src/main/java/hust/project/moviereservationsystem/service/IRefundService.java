package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.RefundEntity;
import hust.project.moviereservationsystem.entity.request.CreateRefundRequest;

public interface IRefundService {
    RefundEntity createRefund(CreateRefundRequest request, Long useId);

    RefundEntity updateRefundStatus(Long refundId, String status);
}
