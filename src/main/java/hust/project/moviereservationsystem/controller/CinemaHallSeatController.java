package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.ICinemaHallSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cinema_hall_seats")
public class CinemaHallSeatController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    private final ICinemaHallSeatService cinemaHallSeatService;

    @PostMapping
    ResponseEntity<Resource> createCinemaHallSeat(@RequestBody CreateCinemaHallSeatRequest request) {
        return ResponseEntity.ok(
                new Resource(cinemaHallSeatService.createCinemaHallSeat(request)));
    }

    @GetMapping
    ResponseEntity<Resource> getAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, name = "cinema_hall_id") Long cinemaHallId,
            @RequestParam(required = false, name = "type") String type
    ) {
        var filter = GetCinemaHallSeatRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .cinemaHallId(cinemaHallId)
                .type(type)
                .build();
        return ResponseEntity.ok(
                new Resource(cinemaHallSeatService.getAll(filter)));
    }

    @PatchMapping("/{id}")
    ResponseEntity<Resource> updateCinemaHallSeat(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateCinemaHallSeatRequest request
            ) {
        return ResponseEntity.ok(
                new Resource(cinemaHallSeatService.updateCinemaHallSeat(id, request)));
    }
}
