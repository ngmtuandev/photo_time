package photo_time_tracking.photo_time.service.implement_service;

import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.role.RoleRequest;
import photo_time_tracking.photo_time.dto.response.role.RoleResponse;
import photo_time_tracking.photo_time.entity.RoleEntity;
import photo_time_tracking.photo_time.enums.ERole;
import photo_time_tracking.photo_time.repositories.IRoleRepo;
import photo_time_tracking.photo_time.service.interface_service.IRoleService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepo roleRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    public RoleServiceImpl(IRoleRepo roleRepo, BaseAmenityUtil baseAmenityUtil) {
        this.roleRepo = roleRepo;
        this.baseAmenityUtil = baseAmenityUtil;
    }

    // build contructor
    @Override
    public Optional<RoleEntity> findByRoleName(ERole roleName) {
        return roleRepo.findByRoleName(roleName);
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }

    // implement interface service

    @Override
    public RoleResponse createRole(RoleRequest role) {

        Optional<RoleEntity> findRoleExist = findByRoleName(role.getRole());
        if (findRoleExist.isPresent()) {
            return new RoleResponse(ResourceBundleConstant.RL_001, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RL_001));
        }
         try {
             RoleEntity newRole = new RoleEntity();
             newRole.setRole(role.getRole());
             roleRepo.save(newRole);
             return new RoleResponse(ResourceBundleConstant.RL_002, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.RL_002));
         }
        catch (Exception e) {
            return new RoleResponse(ResourceBundleConstant.RL_003, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RL_003), e);
        }

    }

    @Override
    public RoleResponse getAllRoles() {
        List<RoleEntity> listRole = roleRepo.findAll();
        if (!listRole.isEmpty()) {
            return new RoleResponse(ResourceBundleConstant.RL_004, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.RL_004), listRole);
        }
        return new RoleResponse(ResourceBundleConstant.RL_005, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RL_005));
    }
}
