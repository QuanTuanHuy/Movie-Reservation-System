package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.SendEmailRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email")
public class EmailController {
    private final IEmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<Resource> sendEmail(@RequestBody SendEmailRequest request) {
        return ResponseEntity.ok(new Resource(
                emailService.sendEmail(request)
        ));
    }
}
