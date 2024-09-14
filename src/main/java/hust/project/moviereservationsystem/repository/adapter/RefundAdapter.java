package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.RefundEntity;
import hust.project.moviereservationsystem.exception.CreateRefundException;
import hust.project.moviereservationsystem.exception.GetRefundException;
import hust.project.moviereservationsystem.mapper.RefundMapper;
import hust.project.moviereservationsystem.model.RefundModel;
import hust.project.moviereservationsystem.port.IRefundPort;
import hust.project.moviereservationsystem.repository.IRefundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefundAdapter implements IRefundPort {
    private final IRefundRepository refundRepository;
    private final RefundMapper refundMapper;

    @Override
    public RefundEntity save(RefundEntity refundEntity) {
        try {
            RefundModel refundModel = refundMapper.toModelFromEntity(refundEntity);
            return refundMapper.toEntityFromModel(refundRepository.save(refundModel));
        } catch (Exception e) {
            throw new CreateRefundException();
        }
    }

    @Override
    public RefundEntity getById(Long id) {
        return refundMapper.toEntityFromModel(refundRepository.findById(id)
                .orElseThrow(GetRefundException::new));
    }

    @Override
    public RefundEntity getByBookingId(Long bookingId) {
        return refundMapper.toEntityFromModel(refundRepository.findByBookingId(bookingId).orElse(null));
    }
}
