package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {
    private String description;
    private CreateCityRequest city;
    private CreateDistrictRequest district;
    private CreateWardRequest ward;
}
