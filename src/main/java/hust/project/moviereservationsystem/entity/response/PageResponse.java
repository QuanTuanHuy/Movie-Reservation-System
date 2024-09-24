package hust.project.moviereservationsystem.entity.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T> {
    private Long totalPage;
    private Long totalRecord;
    private Long pageSize;
    private Long nextPage;
    private Long previousPage;

    private List<T> data;
}
