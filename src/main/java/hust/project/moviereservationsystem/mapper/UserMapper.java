package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.entity.request.CreateUserRequest;
import hust.project.moviereservationsystem.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserEntity toEntityFromModel(UserModel model);

    public abstract UserEntity toEntityFromRequest(CreateUserRequest request);

    public abstract UserModel toModelFromEntity(UserEntity entity);
}
