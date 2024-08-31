package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.request.LoginRequest;
import hust.project.moviereservationsystem.entity.response.LoginResponse;
import hust.project.moviereservationsystem.exception.LoginException;
import hust.project.moviereservationsystem.port.IRolePort;
import hust.project.moviereservationsystem.port.IUserPort;
import hust.project.moviereservationsystem.security.CustomUserDetails;
import hust.project.moviereservationsystem.security.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignInUserUseCase {
    private final IUserPort userPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtils jwtTokenUtils;
    private final IRolePort rolePort;
    private final AuthenticationManager authenticationManager;

    public LoginResponse signIn(LoginRequest request) {
        var user = userPort.getUserByEmail(request.getEmail());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new LoginException();
        }

        var customUserDetails = new CustomUserDetails(user, userPort, rolePort);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getEmail(), request.getPassword(), customUserDetails.getAuthorities());
        authenticationManager.authenticate(authenticationToken);

        var role = rolePort.getRoleById(user.getRoleId());

        return new LoginResponse(user.getEmail(), user.getFirstName(), user.getLastName(),
                jwtTokenUtils.generateToken(user), role.getCode());
    }
}
