package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateCinemaRequest;
import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.ICinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cinemas")
public class CinemaController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    private final ICinemaService cinemaService;

    @PostMapping
    ResponseEntity<Resource> createCinema(@RequestBody CreateCinemaRequest request) {
        return ResponseEntity.ok(new Resource(cinemaService.createCinema(request)));
    }

    @GetMapping
    ResponseEntity<Resource> getAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "city_code") String cityCode

    ) {
        var filter = GetCinemaRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .name(name)
                .cityCode(cityCode)
                .build();
        var result = cinemaService.getAllCinemas(filter);
        return ResponseEntity.ok(new Resource(result));
    }

    @GetMapping("/{id}")
    ResponseEntity<Resource> getDetail(@PathVariable(name = "id") Long cinemaId) {
        return ResponseEntity.ok(new Resource(cinemaService.getDetailCinema(cinemaId)));
    }

    @PatchMapping("/{id}")
    ResponseEntity<Resource> updateCinema(
            @PathVariable(name = "id") Long cinemaId,
            @RequestBody UpdateCinemaRequest request) {
        return ResponseEntity.ok(new Resource(cinemaService.updateCinema(cinemaId, request)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Resource> deleteCinema(@PathVariable(name = "id") Long cinemaId) {
        cinemaService.deleteCinema(cinemaId);
        return ResponseEntity.ok(new Resource(null));
    }
}
