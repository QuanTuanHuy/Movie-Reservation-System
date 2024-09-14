package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.*;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IPromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/promotions")
public class PromotionController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IPromotionService promotionService;

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PostMapping
    public ResponseEntity<Resource> createPromotion(
            @RequestBody CreatePromotionRequest request
    ) {
        return ResponseEntity.ok(new Resource(
                promotionService.createPromotion(request)
        ));
    }

    @GetMapping
    public ResponseEntity<Resource> getAllPromotion(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "description") String description

    ) {
        var filter = GetPromotionRequest.builder()
                .page(page).pageSize(pageSize).description(description).name(name).build();
        return ResponseEntity.ok(new Resource(
                promotionService.getAllPromotions(filter)
        ));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<Resource> getPromotionByCode(
            @PathVariable String code
    ) {
        return ResponseEntity.ok(new Resource(
                promotionService.getPromotionByCode(code)
        ));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Resource> updatePromotion(
            @PathVariable Long id,
            @RequestBody UpdatePromotionRequest request
    ) {
        return ResponseEntity.ok(new Resource(
                promotionService.updatePromotion(id, request)
        ));
    }

}
