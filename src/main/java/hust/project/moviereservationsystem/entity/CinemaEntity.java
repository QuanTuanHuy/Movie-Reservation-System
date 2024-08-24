package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaEntity extends BaseEntity {
    private String name;

    private String cityCode;

    private Long totalCinemaHalls;

    private String phoneNumber;

    private Long addressId;

    private Boolean isActive;

    private AddressEntity address;
}
