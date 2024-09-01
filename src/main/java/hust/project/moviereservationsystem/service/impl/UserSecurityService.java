package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.service.IUserSecurityService;
import hust.project.moviereservationsystem.usecase.GetUserIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements IUserSecurityService {
    private final GetUserIdUseCase getUserIdUseCase;

    @Override
    public Long getUserId() {
        return getUserIdUseCase.getUserId();
    }
}
