package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.RoleEntity;

public interface IRolePort {
    RoleEntity save(RoleEntity roleEntity);

    RoleEntity getRoleByCode(String code);

    RoleEntity getRoleById(Long id);
}
