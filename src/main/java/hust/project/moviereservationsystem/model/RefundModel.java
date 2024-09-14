package hust.project.moviereservationsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "RefundModel")
@Table(name = "refunds")
public class RefundModel extends AuditingEntityListener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id", nullable = false)
    private Long bookingId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "refund_status")
    private String refundStatus;

    @Column(name = "status", nullable = false)
    private String cardNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;
}
