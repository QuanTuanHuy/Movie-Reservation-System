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
@Entity(name = "Ward Model")
@Table(name = "wards")
public class WardModel extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "district_code")
    private String districtCode;
}
