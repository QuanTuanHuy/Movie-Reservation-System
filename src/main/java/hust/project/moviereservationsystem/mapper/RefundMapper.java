package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.RefundEntity;
import hust.project.moviereservationsystem.entity.request.CreateRefundRequest;
import hust.project.moviereservationsystem.model.RefundModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RefundMapper {
    public abstract RefundEntity toEntityFromModel(RefundModel model);

    public abstract RefundModel toModelFromEntity(RefundEntity entity);

    public abstract RefundEntity toEntityFromRequest(CreateRefundRequest request);
}
