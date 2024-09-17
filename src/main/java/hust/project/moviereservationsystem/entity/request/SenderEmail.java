package hust.project.moviereservationsystem.entity.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SenderEmail {
    private String name;
    private String email;
}
