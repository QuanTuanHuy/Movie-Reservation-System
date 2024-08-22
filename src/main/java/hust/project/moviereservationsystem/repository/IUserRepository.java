package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IBaseRepository<UserModel> {
    Optional<UserModel> findByEmail(String email);
}
