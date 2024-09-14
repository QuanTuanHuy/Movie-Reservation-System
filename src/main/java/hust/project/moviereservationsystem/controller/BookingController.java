package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateBookingRequest;
import hust.project.moviereservationsystem.entity.request.GetBookingRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IBookingService;
import hust.project.moviereservationsystem.service.IUserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IBookingService bookingService;
    private final IUserSecurityService userSecurityService;

    @PostMapping
    ResponseEntity<Resource> createBooking(@RequestBody CreateBookingRequest request) {
        Long userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(
                bookingService.createBooking(request, userId)
        ));
    }

    @GetMapping("/my_booking")
    ResponseEntity<Resource> getBookingsByUserId() {
        Long userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(
                bookingService.getBookingsByUserId(userId)
        ));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @GetMapping
    ResponseEntity<Resource> getAllBookings(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, name = "show_id") Long showId,
            @RequestParam(required = false, name = "user_id") Long userId,
            @RequestParam(required = false, name = "status") String status,
            @RequestParam(required = false, name = "start_time") LocalDateTime startTime,
            @RequestParam(required = false, name = "end_time") LocalDateTime endTime
    ) {
        GetBookingRequest filter = GetBookingRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .showId(showId)
                .userId(userId)
                .status(status)
                .startTime(startTime)
                .endTime(endTime)
                .build();
        return ResponseEntity.ok(new Resource(
                bookingService.getAllBookings(filter)
        ));
    }

    @PatchMapping("/{id}/cancel")
    ResponseEntity<Resource> cancelBooking(@PathVariable(name = "id") Long id) {
        Long userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(
                bookingService.cancelBooking(id, userId)
        ));
    }
}
