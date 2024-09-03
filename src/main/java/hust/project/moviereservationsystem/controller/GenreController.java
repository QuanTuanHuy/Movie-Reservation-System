package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateGenreRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
public class GenreController {
    private final IGenreService genreService;

    @PostMapping
    ResponseEntity<Resource> createGenre(@RequestBody CreateGenreRequest request) {
        return ResponseEntity.ok(new Resource(genreService.createGenre(request)));
    }

    @GetMapping
    ResponseEntity<Resource> getAll() {
        return ResponseEntity.ok(new Resource(genreService.getAllGenres()));
    }

    @GetMapping("/{id}")
    ResponseEntity<Resource> getDetail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new Resource(genreService.getDetailGenre(id)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Resource> deleteGenre(@PathVariable(name = "id") Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok(new Resource(null));
    }
}
