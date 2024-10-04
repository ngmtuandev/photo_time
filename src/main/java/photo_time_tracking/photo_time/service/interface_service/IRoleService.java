package photo_time_tracking.photo_time.service.interface_service;

import photo_time_tracking.photo_time.dto.request.role.RoleRequest;
import photo_time_tracking.photo_time.dto.response.role.RoleResponse;

public interface IRoleService {

    RoleResponse createRole(RoleRequest role);

    RoleResponse getAllRoles();
}
