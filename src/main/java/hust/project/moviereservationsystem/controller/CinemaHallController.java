package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaHallRequest;
import hust.project.moviereservationsystem.service.ICinemaHallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CinemaHallController {
    private final ICinemaHallService cinemaHallService;

    @PostMapping("/cinema_halls")
    ResponseEntity<CinemaHallEntity> createCinema(@RequestBody CreateCinemaHallRequest request) {
        return ResponseEntity.ok(cinemaHallService.createCinemaHall(request));
    }

    @GetMapping("/cinemas/{cinema_id}/cinema_halls")
    ResponseEntity<List<CinemaHallEntity>> getByCinemaId(@PathVariable(name = "cinema_id") Long cinemaId) {
        return ResponseEntity.ok(cinemaHallService.getCinemaHallsByCinemaId(cinemaId));
    }
}
