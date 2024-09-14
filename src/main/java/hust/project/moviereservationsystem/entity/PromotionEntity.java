package hust.project.moviereservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionEntity extends BaseEntity {
    private String name;
    private String description;
    private String code;
    private Long discountPercentage;
    private Boolean isActive;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
