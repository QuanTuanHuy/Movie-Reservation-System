package hust.project.moviereservationsystem.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private Long roleId;

    private Long addressId;

    private String gender;

    private LocalDate dateOfBirth;
}
