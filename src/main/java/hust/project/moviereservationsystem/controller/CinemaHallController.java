package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateCinemaHallRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.ICinemaHallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CinemaHallController {
    private final ICinemaHallService cinemaHallService;

    @PostMapping("/cinema_halls")
    ResponseEntity<Resource> createCinema(@RequestBody CreateCinemaHallRequest request) {
        return ResponseEntity.ok(
                new Resource(cinemaHallService.createCinemaHall(request)));
    }

    @GetMapping("/cinemas/{cinema_id}/cinema_halls")
    ResponseEntity<Resource> getByCinemaId(@PathVariable(name = "cinema_id") Long cinemaId) {
        return ResponseEntity.ok(
                new Resource(cinemaHallService.getCinemaHallsByCinemaId(cinemaId)));
    }
}
