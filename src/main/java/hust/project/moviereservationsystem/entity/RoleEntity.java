package hust.project.moviereservationsystem.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity extends BaseEntity {
    private String name;
    private String code;
    private String description;
}
