package hust.project.moviereservationsystem.utils;

import hust.project.moviereservationsystem.entity.response.PageInfo;
import org.springframework.data.domain.Page;

public class PageInfoUtils {
    public static <T> PageInfo getPageInfo(Page<T> result) {
        var pageInfo = new PageInfo();
        pageInfo.setTotalRecord(result.getTotalElements());
        pageInfo.setTotalPage((long) result.getTotalPages());
        pageInfo.setPageSize((long) result.getSize());
        if (result.hasNext()) {
            pageInfo.setNextPage((long) result.nextPageable().getPageNumber());
        }

        if (result.hasPrevious()) {
            pageInfo.setPreviousPage((long) result.previousPageable().getPageNumber());
        }
        return pageInfo;
    }
}
