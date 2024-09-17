package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.model.UserModel;

import java.util.List;

public interface IUserPort {
    UserEntity save(UserEntity userEntity);

    UserEntity getUserByEmail(String email);

    UserEntity getUserById(Long id);

    List<UserEntity> getAllUsers();
}
