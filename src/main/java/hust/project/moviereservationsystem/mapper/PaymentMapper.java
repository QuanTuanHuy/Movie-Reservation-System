package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.PaymentEntity;
import hust.project.moviereservationsystem.entity.request.CreatePaymentRequest;
import hust.project.moviereservationsystem.model.PaymentModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper {
    public abstract PaymentEntity toEntityFromModel(PaymentModel model);

    public abstract PaymentModel toModelFromEntity(PaymentEntity entity);

    public abstract List<PaymentEntity> toEntitiesFromModels(List<PaymentModel> models);

    public abstract PaymentEntity toEntityFromRequest(CreatePaymentRequest request);
}
