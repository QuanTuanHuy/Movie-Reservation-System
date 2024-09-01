package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.exception.BadRequestException;
import hust.project.moviereservationsystem.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserIdUseCase {
    public Long getUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("Principal class: {}", principal);
        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getUserEntity().getId();
        }
        log.error("[GetUseIdUseCase] cannot get user id");
        throw new BadRequestException();
    }
}
