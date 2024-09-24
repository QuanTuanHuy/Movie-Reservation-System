package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.exception.CreateUserException;
import hust.project.moviereservationsystem.mapper.UserMapper;
import hust.project.moviereservationsystem.port.IUserPort;
import hust.project.moviereservationsystem.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAdapter implements IUserPort {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserEntity save(UserEntity userEntity) {
        try {
            var userModel = userMapper.toModelFromEntity(userEntity);
            return userMapper.toEntityFromModel(userRepository.save(userModel));
        } catch (Exception e) {
            log.error("[UserAdapter] save user failed]");
            throw new CreateUserException();
        }
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userMapper.toEntityFromModel(userRepository.findByEmail(email).orElse(null));
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userMapper.toEntityFromModel(userRepository.findById(id).orElse(null));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toEntityFromModel).toList();
    }

    @Override
    public List<UserEntity> getUsersByIds(List<Long> ids) {
        return userRepository.findAllById(ids).stream().map(userMapper::toEntityFromModel).toList();
    }


}
