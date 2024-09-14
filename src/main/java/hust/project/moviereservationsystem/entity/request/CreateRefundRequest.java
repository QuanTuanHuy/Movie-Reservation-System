package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRefundRequest {
    private Long bookingId;
    private String cardNumber;
    private String bankName;
}
