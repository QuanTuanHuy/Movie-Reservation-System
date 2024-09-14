package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity extends BaseEntity {
    private Long bookingId;
    private Long amount;
    private String status;
    private String paymentMethod;
    private Long promotionId;
    private Long finalAmount;
}
