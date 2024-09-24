package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.UserEntity;

import java.util.List;

public interface IUserPort {
    UserEntity save(UserEntity userEntity);

    UserEntity getUserByEmail(String email);

    UserEntity getUserById(Long id);

    List<UserEntity> getAllUsers();

    List<UserEntity> getUsersByIds(List<Long> ids);
}
