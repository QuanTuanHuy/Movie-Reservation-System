package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.entity.request.CreatePaymentRequest;
import hust.project.moviereservationsystem.service.IPaymentService;
import hust.project.moviereservationsystem.usecase.CreatePaymentUseCase;
import hust.project.moviereservationsystem.usecase.UpdatePaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final CreatePaymentUseCase createPaymentUseCase;

    private final UpdatePaymentUseCase updatePaymentUseCase;

    @Override
    public PaymentEntity createPayment(CreatePaymentRequest request) {
        return createPaymentUseCase.createPayment(request);
    }

    @Override
    public PaymentEntity updatePaymentStatus(Long paymentId, String status) {
        return updatePaymentUseCase.updatePaymentStatus(paymentId, status);
    }


}
