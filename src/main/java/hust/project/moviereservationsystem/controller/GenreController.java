package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateGenreRequest;
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
    ResponseEntity<GenreEntity> createGenre(@RequestBody CreateGenreRequest request) {
        return ResponseEntity.ok(genreService.createGenre(request));
    }

    @GetMapping("/{id}")
    ResponseEntity<GenreEntity> getDetail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(genreService.getDetailGenre(id));
    }
}
