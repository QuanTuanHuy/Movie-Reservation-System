package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreatePaymentRequest;
import hust.project.moviereservationsystem.entity.request.UpdatePaymentStatusRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final IPaymentService paymentService;

    @PostMapping
    public ResponseEntity<Resource> createPayment(@RequestBody CreatePaymentRequest request) {
        return ResponseEntity.ok(new Resource(
                paymentService.createPayment(request)
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> updatePaymentStatus(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdatePaymentStatusRequest request
    ) {
        return ResponseEntity.ok(new Resource(
                paymentService.updatePaymentStatus(id, request.getStatus())
        ));
    }

}
