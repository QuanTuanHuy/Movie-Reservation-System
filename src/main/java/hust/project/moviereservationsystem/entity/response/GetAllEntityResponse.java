package hust.project.moviereservationsystem.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEntityResponse {
    private PageInfo pageInfo;
    private Object data;
}
