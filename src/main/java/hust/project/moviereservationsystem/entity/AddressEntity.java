package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity extends BaseEntity {
    private String description;
    private String cityCode;
    private String districtCode;
    private String wardCode;

    private CityEntity city;
    private DistrictEntity district;
    private WardEntity ward;
}
