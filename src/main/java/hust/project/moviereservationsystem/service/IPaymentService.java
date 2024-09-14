package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.entity.request.CreatePaymentRequest;

public interface IPaymentService {

    PaymentEntity createPayment(CreatePaymentRequest request);

    PaymentEntity updatePaymentStatus(Long paymentId, String status);
}
