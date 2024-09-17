package hust.project.moviereservationsystem.entity.request;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendEmailRequest {
    RecipientEMail to;
    String subject;
    String htmlContent;
    Map<String, String> params;
}
