package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.RoleEntity;
import hust.project.moviereservationsystem.model.RoleModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {
    public abstract RoleEntity toEntityFromModel(RoleModel model);

    public abstract RoleModel toModelFromEntity(RoleEntity entity);
}
