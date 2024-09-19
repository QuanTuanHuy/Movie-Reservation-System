package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.constant.PaymentStatus;
import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.entity.request.CreatePaymentRequest;
import hust.project.moviereservationsystem.event.dto.PaymentEvent;
import hust.project.moviereservationsystem.service.IPaymentService;
import hust.project.moviereservationsystem.usecase.CreatePaymentUseCase;
import hust.project.moviereservationsystem.usecase.UpdatePaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final CreatePaymentUseCase createPaymentUseCase;

    private final UpdatePaymentUseCase updatePaymentUseCase;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public PaymentEntity createPayment(CreatePaymentRequest request) {
        return createPaymentUseCase.createPayment(request);
    }

    @Override
    public PaymentEntity updatePaymentStatus(Long paymentId, String status) {
        PaymentEntity payment = updatePaymentUseCase.updatePaymentStatus(paymentId, status);

        PaymentEvent paymentEvent = PaymentEvent.builder()
                .paymentId(paymentId)
                .status(PaymentStatus.valueOf(status).name())
                .build();
        kafkaTemplate.send("payment_event", paymentEvent);

        return payment;
    }

}
