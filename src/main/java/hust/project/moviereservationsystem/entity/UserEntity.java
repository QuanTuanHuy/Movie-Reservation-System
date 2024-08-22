package hust.project.moviereservationsystem.entity;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private Long roleId;

    private Long addressId;

    private String gender;

    private LocalDateTime dateOfBirth;
}
