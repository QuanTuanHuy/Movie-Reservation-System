package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.GetStatisticRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistic")
public class StatisticController {
    private final IStatisticService statisticService;

    @GetMapping
    ResponseEntity<Resource> getStatistic(
            @RequestParam(required = false, name = "movie_id") Long movieId,
            @RequestParam(required = false, name = "cinema_id") Long cinemaId,
            @RequestParam(required = false, name = "start_date") LocalDate startDate,
            @RequestParam(required = false, name = "end_date") LocalDate endDate
    ) {
        GetStatisticRequest request = GetStatisticRequest.builder()
                .cinemaId(cinemaId)
                .movieId(movieId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        return ResponseEntity.ok(new Resource(statisticService.getStatistic(request)));
    }

}
