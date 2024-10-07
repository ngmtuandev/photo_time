package photo_time_tracking.photo_time.service.interface_service;

import photo_time_tracking.photo_time.dto.request.role.RoleRequest;
import photo_time_tracking.photo_time.dto.response.role.RoleResponse;
import photo_time_tracking.photo_time.entity.RoleEntity;
import photo_time_tracking.photo_time.enums.ERole;

import java.util.Optional;

public interface IRoleService {

    RoleResponse createRole(RoleRequest role);

    RoleResponse getAllRoles();

    Optional<RoleEntity> findByRoleName(ERole roleName);
}
