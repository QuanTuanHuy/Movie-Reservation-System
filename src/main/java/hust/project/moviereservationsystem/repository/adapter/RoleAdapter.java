package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.RoleEntity;
import hust.project.moviereservationsystem.exception.CreatRoleException;
import hust.project.moviereservationsystem.exception.GetRoleException;
import hust.project.moviereservationsystem.mapper.RoleMapper;
import hust.project.moviereservationsystem.model.RoleModel;
import hust.project.moviereservationsystem.port.IRolePort;
import hust.project.moviereservationsystem.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleAdapter implements IRolePort {
    private final IRoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        try {
            var roleModel = roleMapper.toModelFromEntity(roleEntity);
            return roleMapper.toEntityFromModel(roleRepository.save(roleModel));
        } catch (Exception e) {
            throw new CreatRoleException();
        }
    }

    @Override
    public RoleEntity getRoleByCode(String code) {
        Optional<RoleModel> role = roleRepository.findByCode(code);
        if (role.isEmpty()) {
            log.error("[RoleAdapter] role not found, code: {}", code);
            throw new GetRoleException();
        }
        return roleMapper.toEntityFromModel(role.get());
    }

    @Override
    public RoleEntity getRoleById(Long id) {
        Optional<RoleModel> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            log.error("[RoleAdapter] role not found, id: {}", id);
            throw new GetRoleException();
        }
        return roleMapper.toEntityFromModel(role.get());
    }
}
