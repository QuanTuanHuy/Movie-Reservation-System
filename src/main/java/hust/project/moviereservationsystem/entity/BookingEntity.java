package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity extends BaseEntity {
    private Long userId;
    private Long showId;
    private Long totalSeats;
    private String status;
    private Long totalPrice;
    private String paymentMethod;
    private String paymentStatus;
    private String note;
    private LocalDateTime createdAt;

    private ShowEntity show;
}
