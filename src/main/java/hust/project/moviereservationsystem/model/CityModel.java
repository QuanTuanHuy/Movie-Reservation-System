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
@Entity(name = "City Model")
@Table(name = "cities")
public class CityModel extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
