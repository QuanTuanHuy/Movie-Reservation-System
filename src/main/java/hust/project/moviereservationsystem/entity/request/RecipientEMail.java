package hust.project.moviereservationsystem.entity.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipientEMail {
    String name;
    String email;
}
