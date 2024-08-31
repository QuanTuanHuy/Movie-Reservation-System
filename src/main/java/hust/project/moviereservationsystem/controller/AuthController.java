package hust.project.moviereservationsystem.controller;

import hust.project.moviereservationsystem.entity.request.CreateUserRequest;
import hust.project.moviereservationsystem.entity.request.LoginRequest;
import hust.project.moviereservationsystem.entity.response.Resource;
import hust.project.moviereservationsystem.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final IUserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<Resource> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(
                new Resource(userService.signUp(request))
        );
    }

    @PostMapping("/login")
    public ResponseEntity<Resource> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                new Resource(userService.login(request)));
    }
}
