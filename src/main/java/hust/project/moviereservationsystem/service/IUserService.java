package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.request.CreateUserRequest;
import hust.project.moviereservationsystem.entity.request.LoginRequest;
import hust.project.moviereservationsystem.entity.response.LoginResponse;
import hust.project.moviereservationsystem.entity.response.SignUpResponse;

public interface IUserService {
    SignUpResponse signUp(CreateUserRequest request);

    LoginResponse login(LoginRequest request);
}
