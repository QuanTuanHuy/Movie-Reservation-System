package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.exception.CreatePaymentException;
import hust.project.moviereservationsystem.exception.GetPaymentException;
import hust.project.moviereservationsystem.mapper.PaymentMapper;
import hust.project.moviereservationsystem.model.PaymentModel;
import hust.project.moviereservationsystem.port.IPaymentPort;
import hust.project.moviereservationsystem.repository.IPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentAdapter implements IPaymentPort {
    private final IPaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentEntity save(PaymentEntity paymentEntity) {
        try {
            PaymentModel paymentModel = paymentMapper.toModelFromEntity(paymentEntity);
            return paymentMapper.toEntityFromModel(paymentRepository.save(paymentModel));
        } catch (Exception e) {
            throw new CreatePaymentException();
        }
    }

    @Override
    public PaymentEntity getPaymentById(Long id) {
        return paymentMapper.toEntityFromModel(paymentRepository.findById(id).orElse(null));
    }

    @Override
    public PaymentEntity getPaymentByBookingId(Long bookingId) {
        return paymentMapper.toEntityFromModel(paymentRepository.findByBookingId(bookingId)
                .orElseThrow(GetPaymentException::new));
    }

    @Override
    public List<PaymentEntity> getPaymentsByBookingIds(List<Long> bookingIds) {
        return paymentMapper.toEntitiesFromModels(
                paymentRepository.findByBookingIdIn(bookingIds)
        );
    }
}
