package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateRefundRequest;
import hust.project.moviereservationsystem.entity.request.UpdateRefundStatusRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IRefundService;
import hust.project.moviereservationsystem.service.IUserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/refunds")
public class RefundController {
    public final IRefundService refundService;
    public final IUserSecurityService userSecurityService;

    @PostMapping
    public ResponseEntity<Resource> createRefund(
            @RequestBody CreateRefundRequest request
    ) {
        Long userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(
                refundService.createRefund(request, userId)
        ));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PutMapping("/{refund_id}")
    public ResponseEntity<Resource> updateRefundStatus(
            @PathVariable(name = "refund_id") Long refundId,
            @RequestBody UpdateRefundStatusRequest request
    ) {
        return ResponseEntity.ok(new Resource(
                refundService.updateRefundStatus(refundId, request.getStatus())
        ));
    }

}
