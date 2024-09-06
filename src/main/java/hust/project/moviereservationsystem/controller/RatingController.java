package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateRatingRequest;
import hust.project.moviereservationsystem.entity.request.GetRatingRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IRatingService;
import hust.project.moviereservationsystem.service.IUserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ratings")
public class RatingController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IRatingService ratingService;
    private final IUserSecurityService userSecurityService;

    @PostMapping
    public ResponseEntity<Resource> createRating(
            @RequestBody CreateRatingRequest request
    ) {
        Long userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(
                ratingService.createRating(request, userId)
        ));
    }

    @GetMapping("/average")
    public ResponseEntity<Resource> getAverageStar(
            @RequestParam(name = "movie_id") Long movieId
    ) {
        return ResponseEntity.ok(new Resource(
                ratingService.getAverageStarByMovieId(movieId)
        ));
    }

    @GetMapping
    public ResponseEntity<Resource> getAllRatings(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, name = "movie_id") Long movieId,
            @RequestParam(required = false, name = "user_id") Long userId,
            @RequestParam(required = false, name = "user_name") String userName,
            @RequestParam(required = false, name = "rating_star") Long ratingStar,
            @RequestParam(required = false, name = "content") String content,
            @RequestParam(required = false, name = "created_from") LocalDateTime createdFrom,
            @RequestParam(required = false, name = "created_to") LocalDateTime createdTo
    ) {
        GetRatingRequest filter = GetRatingRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .movieId(movieId)
                .content(content)
                .userId(userId)
                .userName(userName)
                .ratingStar(ratingStar)
                .createdFrom(createdFrom)
                .createdTo(createdTo)
                .build();
        return ResponseEntity.ok(new Resource(
                ratingService.getAllRatings(filter)
        ));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Resource> deleteRating(
            @PathVariable(name = "id") Long id
    ) {
        ratingService.deleteRating(id);
        return ResponseEntity.ok(new Resource(null));
    }
}
