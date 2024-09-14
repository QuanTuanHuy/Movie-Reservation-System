package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {
    private Long bookingId;
    private Long promotionId;
    private String paymentMethod;
}
