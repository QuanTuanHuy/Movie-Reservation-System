package hust.project.moviereservationsystem.event.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEvent {
    private Long paymentId;
    private String status;
}
