package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateMovieRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    private final IMovieService movieService;

    @PostMapping
    ResponseEntity<Resource> createMovie(@RequestBody CreateMovieRequest request) {
        return ResponseEntity.ok(new Resource(movieService.createMovie(request)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Resource> getDetail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new Resource(movieService.getDetailMovie(id)));
    }

    @GetMapping
    ResponseEntity<Resource> getAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, defaultValue = "", name = "title") String title,
            @RequestParam(required = false, defaultValue = "", name = "genre") String genre,
            @RequestParam(required = false, defaultValue = "", name = "language") String language,
            @RequestParam(required = false, name = "release_date") LocalDate releaseDate

    ) {
        var filter = GetMovieRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .title(title)
                .genre(genre)
                .language(language)
                .releaseDate(releaseDate != null ? releaseDate : LocalDate.now())
                .build();
        return ResponseEntity.ok(new Resource(movieService.getAllMovies(filter)));
    }

    @PutMapping("/{id}")
    ResponseEntity<Resource> updateMovie(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateMovieRequest request
    ) {
        return ResponseEntity.ok(new Resource(movieService.updateMovie(id, request)));
    }
    
    @DeleteMapping("/{id}")
    ResponseEntity<Resource> deleteMovie(@PathVariable(name = "id") Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok(new Resource(null));
    }
}
