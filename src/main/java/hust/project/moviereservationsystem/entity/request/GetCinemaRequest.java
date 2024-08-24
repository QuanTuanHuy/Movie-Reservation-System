package hust.project.moviereservationsystem.entity.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCinemaRequest {
    private Long page;
    private Long pageSize;
    private String name;
    private String cityCode;
}
