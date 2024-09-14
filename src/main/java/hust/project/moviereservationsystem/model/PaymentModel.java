package hust.project.moviereservationsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PaymentModel")
@Table(name = "payments")
public class PaymentModel extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "final_amount")
    private Long finalAmount;

    @Column(name = "payment_status")
    private String status;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "promotion_id")
    private Long promotionId;
}
