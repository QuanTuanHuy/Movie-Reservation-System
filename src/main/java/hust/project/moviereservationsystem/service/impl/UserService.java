package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.request.CreateUserRequest;
import hust.project.moviereservationsystem.entity.request.LoginRequest;
import hust.project.moviereservationsystem.entity.response.LoginResponse;
import hust.project.moviereservationsystem.entity.response.SignUpResponse;
import hust.project.moviereservationsystem.service.IUserService;
import hust.project.moviereservationsystem.usecase.CreateUserUseCase;
import hust.project.moviereservationsystem.usecase.SignInUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final CreateUserUseCase createUserUseCase;
    private final SignInUserUseCase signInUserUseCase;

    @Override
    public SignUpResponse signUp(CreateUserRequest request) {
        return createUserUseCase.createUser(request);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return signInUserUseCase.signIn(request);
    }
}
