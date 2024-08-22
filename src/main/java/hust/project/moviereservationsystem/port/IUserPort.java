package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.model.UserModel;

public interface IUserPort {
    UserEntity save(UserEntity userEntity);

    UserEntity getUserByEmail(String email);

    UserEntity getUserById(Long id);
}
