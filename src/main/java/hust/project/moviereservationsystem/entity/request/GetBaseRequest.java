package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBaseRequest {
    public Long page;
    public Long pageSize;
}
