package hust.project.moviereservationsystem.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    private Object meta;
    private Object data;

    public Resource(Object data) {
        this.data = data;
        this.meta = new MetaResource((long) HttpStatus.OK.value(), "Success");
    }

    public Resource(Long code, String message) {
        this.meta = new MetaResource(code, message);
        this.data = null;
    }
}
