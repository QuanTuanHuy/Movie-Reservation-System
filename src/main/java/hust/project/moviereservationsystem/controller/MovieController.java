package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.request.CreateMovieRequest;
import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    private final IMovieService movieService;

    @PostMapping
    ResponseEntity<MovieEntity> createMovie(@RequestBody CreateMovieRequest request) {
        return ResponseEntity.ok(movieService.createMovie(request));
    }

    @GetMapping("/{movieId}")
    ResponseEntity<MovieEntity> getDetail(@PathVariable(name = "movieId") Long movieId) {
        return ResponseEntity.ok(movieService.getDetailMovie(movieId));
    }

    @GetMapping
    ResponseEntity<Pair<PageInfo, List<MovieEntity>>> getAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, name = "title") String title,
            @RequestParam(required = false, name = "genre") String genre,
            @RequestParam(required = false, name = "language") String language,
            @RequestParam(required = false, name = "release_date") LocalDate releaseDate

    ) {
        var filter = GetMovieRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .title(title)
                .genre(genre)
                .language(language)
                .releaseDate(releaseDate)
                .build();
        return ResponseEntity.ok(movieService.getAllMovies(filter));
    }
    
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable(name = "id") Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
