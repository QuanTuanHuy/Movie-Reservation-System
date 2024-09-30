package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.ISearchMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies/_search")
public class SearchMovieController {
    private final ISearchMovieService searchMovieService;


    @GetMapping("/{id}")
    ResponseEntity<Resource> getDetail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new Resource(searchMovieService.getMovieById(id)));
    }

}
