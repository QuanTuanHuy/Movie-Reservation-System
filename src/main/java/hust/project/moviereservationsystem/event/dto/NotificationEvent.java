package hust.project.moviereservationsystem.event.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEvent {
    String chanel;
    String recipient;
    String templateCode;
    Map<String, Object> params;
    String subject;
    String body;
}
