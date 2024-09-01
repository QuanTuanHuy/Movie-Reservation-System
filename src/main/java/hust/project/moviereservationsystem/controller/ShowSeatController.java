package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.BookShowSeatsRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IShowSeatService;
import hust.project.moviereservationsystem.service.IUserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/show_seats")
public class ShowSeatController {

    private final IShowSeatService showSeatService;
    private final IUserSecurityService userSecurityService;

    @GetMapping
    ResponseEntity<Resource> getAll(@RequestParam(name = "show_id") Long showId) {
        return ResponseEntity.ok(new Resource(
                showSeatService.getAllByShowId(showId)));
    }

    @PostMapping
    ResponseEntity<Resource> bookShowSeats(@RequestBody BookShowSeatsRequest request) {
        Long userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(
                showSeatService.assignShowSeatsToUser(request.getShowSeatIds(), userId)));
    }

}
