package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateCommentOnMovieRequest;
import hust.project.moviereservationsystem.entity.request.UpdateCommentOnMovieRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.ICommentOnMovieService;
import hust.project.moviereservationsystem.service.IUserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentOnMovieController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    private final ICommentOnMovieService commentOnMovieService;
    private final IUserSecurityService userSecurityService;

    @PostMapping
    ResponseEntity<Resource> createComment(@RequestBody CreateCommentOnMovieRequest request) {
        Long userId = userSecurityService.getUserId();
        request.setUserId(userId);
        return ResponseEntity.ok(new Resource(commentOnMovieService.createCommentOnMovie(request)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Resource> getDetail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new Resource(commentOnMovieService.getCommentOnMovieDetail(id)));
    }

    @GetMapping
    ResponseEntity<Resource> getAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Integer page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Integer pageSize,
            @RequestParam(name = "movie_id") Long movieId

    ) {
        return ResponseEntity.ok(new Resource(commentOnMovieService.getCommentByMovieId(movieId, page, pageSize)));
    }

    @PutMapping("/{id}")
    ResponseEntity<Resource> updateComment(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateCommentOnMovieRequest request
    ) {
        Long userId = userSecurityService.getUserId();
        request.setUserId(userId);
        return ResponseEntity.ok(new Resource(commentOnMovieService.updateCommentOnMovie(id, request)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Resource> deleteMovie(@PathVariable(name = "id") Long id) {
        Long userId = userSecurityService.getUserId();
        commentOnMovieService.deleteCommentOnMovie(userId, id);
        return ResponseEntity.ok(new Resource(null));
    }
}
