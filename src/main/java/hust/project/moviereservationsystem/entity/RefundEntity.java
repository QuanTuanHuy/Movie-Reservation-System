package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefundEntity extends BaseEntity {
    private Long bookingId;

    private String cardNumber;

    private String bankName;

    private Long userId;

    private Long amount;

    private String refundStatus;
}
