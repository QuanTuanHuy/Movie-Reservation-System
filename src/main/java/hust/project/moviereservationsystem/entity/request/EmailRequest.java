package hust.project.moviereservationsystem.entity.request;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequest {
    SenderEmail sender;
    List<RecipientEMail> to;
    String subject;
    String htmlContent;
    Map<String, String> params;
}
