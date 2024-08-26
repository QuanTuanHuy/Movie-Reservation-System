package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateShowRequest;
import hust.project.moviereservationsystem.entity.request.GetShowRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ShowController {
    private final IShowService showService;

    @PostMapping("/shows")
    ResponseEntity<Resource> createShow(@RequestBody CreateShowRequest request) {
        return ResponseEntity.ok(new Resource(showService.createShow(request)));
    }

    @GetMapping("/cinemas/{cinema_id}/shows")
    ResponseEntity<Resource> getShowsByCinemaIdAndDate(
            @PathVariable(name = "cinema_id") Long cinemaId,
            @RequestParam (name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
            ) {
        return ResponseEntity.ok(new Resource(showService.getShowsByCinemaIdAndDate(cinemaId, date)));
    }

    @GetMapping("/shows")
    ResponseEntity<Resource> getAllShows(
            @RequestParam(name = "movie_id") Long movieId,
            @RequestParam (name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        var filter = GetShowRequest.builder()
                .movieId(movieId)
                .date(date)
                .build();
        return ResponseEntity.ok(new Resource(showService.getAllShows(filter)));
    }

    @GetMapping("shows/{id}")
    ResponseEntity<Resource> getDetail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new Resource(showService.getDetailShow(id)));
    }

    @DeleteMapping("shows/{id}")
    ResponseEntity<Resource> deleteShow(@PathVariable(name = "id") Long id) {
        showService.deleteShow(id);
        return ResponseEntity.ok(new Resource(null));
    }
}
