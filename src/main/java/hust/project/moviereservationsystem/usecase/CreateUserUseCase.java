package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.request.CreateUserRequest;
import hust.project.moviereservationsystem.entity.response.SignUpResponse;
import hust.project.moviereservationsystem.exception.UserEmailException;
import hust.project.moviereservationsystem.mapper.UserMapper;
import hust.project.moviereservationsystem.port.IUserPort;
import hust.project.moviereservationsystem.security.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUserUseCase {
//    public static final Long DEFAULT_ROLE_MOD_ID = 3L;

    public static final Long DEFAULT_ROLE_USER_ID = 2L;

    private final IUserPort userPort;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtils jwtTokenUtils;

    @Transactional(rollbackFor = Exception.class)
    public SignUpResponse createUser(CreateUserRequest request) {
        var existedUser = userPort.getUserByEmail(request.getEmail());
        if (existedUser != null) {
            throw new UserEmailException();
        }

        var user = userMapper.toEntityFromRequest(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleId(request.getRoleId() != null ? request.getRoleId() : DEFAULT_ROLE_USER_ID);
        user = userPort.save(user);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getEmail(), request.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);

        return new SignUpResponse(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                jwtTokenUtils.generateToken(user));
    }

}
