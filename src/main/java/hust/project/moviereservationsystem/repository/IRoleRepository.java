package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.RoleModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends IBaseRepository<RoleModel> {
    Optional<RoleModel> findByCode(String code);
}
