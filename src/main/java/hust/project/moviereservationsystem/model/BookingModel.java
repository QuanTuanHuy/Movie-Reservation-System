package hust.project.moviereservationsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Booking Model")
@Table(name = "bookings")
public class BookingModel extends BaseModel {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "show_id")
    private Long showId;

    @Column(name = "total_seats")
    private Long totalSeats;

    @Column(name = "status")
    private String status;

    @Column(name = "totalPrice")
    private Long totalPrice;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "note")
    private String note;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
