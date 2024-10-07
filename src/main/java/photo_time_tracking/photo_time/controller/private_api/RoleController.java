package photo_time_tracking.photo_time.controller.private_api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.RoleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.role.RoleRequest;
import photo_time_tracking.photo_time.dto.response.role.RoleResponse;
import photo_time_tracking.photo_time.service.implement_service.RoleServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + RoleConstant.API_ROLES)
@Validated
public class RoleController {

    @Autowired
    RoleServiceImpl roleService;

    //TODO: FIX VALIDATE FIELD REQUEST
    @PostMapping()
    public ResponseEntity<RoleResponse> createRole(@Valid @RequestBody RoleRequest createRoleInfo) {
        RoleResponse response = roleService.createRole(createRoleInfo);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<RoleResponse> getRoles() {
        RoleResponse response = roleService.getAllRoles();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
