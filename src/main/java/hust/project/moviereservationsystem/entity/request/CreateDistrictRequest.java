package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDistrictRequest {
    private String name;
    private String code;
    private String cityCode;
}
