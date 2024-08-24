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
@Entity(name = "Cinema Model")
@Table(name = "cinemas")
public class CinemaModel extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "total_cinema_halls")
    private Long totalCinemaHalls;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "address_id")
    private Long addressId;
}
