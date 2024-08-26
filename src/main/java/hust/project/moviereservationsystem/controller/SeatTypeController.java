package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateSeatTypeRequest;
import hust.project.moviereservationsystem.entity.request.UpdateSeatTypeRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.ISeatTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/seat_types")
public class SeatTypeController {
    private final ISeatTypeService seatTypeService;

    @PostMapping
    ResponseEntity<Resource> createSeatType(@RequestBody CreateSeatTypeRequest request) {
        return ResponseEntity.ok(new Resource(seatTypeService.createSeatType(request)));
    }

    @GetMapping
    ResponseEntity<Resource> getAllSeatTypes() {
        return ResponseEntity.ok(new Resource(seatTypeService.getAllSeatTypes()));
    }

    @PatchMapping("/{id}")
    ResponseEntity<Resource> updateSeatType(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateSeatTypeRequest request
    ) {
        return ResponseEntity.ok(new Resource(seatTypeService.updateSeatType(id, request)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Resource> deleteSeatType(@PathVariable(name = "id") Long id) {
        seatTypeService.deleteSeatType(id);
        return ResponseEntity.ok(new Resource(null));
    }
}
