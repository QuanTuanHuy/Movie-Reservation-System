package hust.project.moviereservationsystem.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreEntity extends BaseEntity {
    private String name;
    private String description;
}
