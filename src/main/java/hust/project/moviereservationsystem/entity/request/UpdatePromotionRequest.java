package hust.project.moviereservationsystem.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePromotionRequest {
    private String name;
    private String description;
    private Long discountPercentage;
    Boolean isActive;
}
