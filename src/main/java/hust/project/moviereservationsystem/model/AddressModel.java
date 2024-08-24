package hust.project.moviereservationsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Address Model")
@Table(name = "address")
public class AddressModel extends BaseModel {
    @Column(name = "description")
    private String description;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "district_id")
    private String districtCode;

    @Column(name = "ward_code")
    private String wardCode;
}
