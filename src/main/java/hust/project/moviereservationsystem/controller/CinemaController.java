package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaRequest;
import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.ICinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cinemas")
public class CinemaController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    private final ICinemaService cinemaService;

    @PostMapping
    ResponseEntity<CinemaEntity> createCinema(@RequestBody CreateCinemaRequest request) {
        return ResponseEntity.ok(cinemaService.createCinema(request));
    }

    @GetMapping
    ResponseEntity<Pair<PageInfo, List<CinemaEntity>>> getAll(
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
        return ResponseEntity.ok(cinemaService.getAllCinemas(filter));
    }

    @GetMapping("/{id}")
    ResponseEntity<CinemaEntity> getDetail(@PathVariable(name = "id") Long cinemaId) {
        return ResponseEntity.ok(cinemaService.getDetailCinema(cinemaId));
    }

    @PatchMapping("/{id}")
    ResponseEntity<CinemaEntity> updateCinema(
            @PathVariable(name = "id") Long cinemaId,
            @RequestBody UpdateCinemaRequest request) {
        return ResponseEntity.ok(cinemaService.updateCinema(cinemaId, request));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCinema(@PathVariable(name = "id") Long cinemaId) {
        cinemaService.deleteCinema(cinemaId);
        return ResponseEntity.noContent().build();
    }
}
