package photo_time_tracking.photo_time.service.implement_service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.configurations.CustomUserDetail;
import photo_time_tracking.photo_time.configurations.JwtProvider;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.user.LoginRequest;
import photo_time_tracking.photo_time.dto.request.user.RegisterRequest;
import photo_time_tracking.photo_time.dto.request.user.UpdateUserRequest;
import photo_time_tracking.photo_time.dto.response.user.UserResponse;
import photo_time_tracking.photo_time.entity.RoleEntity;
import photo_time_tracking.photo_time.entity.UserEntity;
import photo_time_tracking.photo_time.repositories.IRoleRepo;
import photo_time_tracking.photo_time.repositories.IUserRepo;
import photo_time_tracking.photo_time.service.interface_service.IUserService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepo userRepo;

    private final IRoleRepo roleRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public UserServiceImpl(IUserRepo userRepo, BaseAmenityUtil baseAmenityUtil, IRoleRepo roleRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.baseAmenityUtil = baseAmenityUtil;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }


    @Override
    public UserEntity findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepo.existsByUserName(userName);
    }

    @Override
    public UserResponse register(RegisterRequest request) {
        Optional<RoleEntity> findRole = roleRepo.findById(request.getRole());
        if (findRole.isPresent()) {
            try {
                UserEntity newUser = new UserEntity();
                newUser.setUserName(request.getUserName());
                newUser.setDescription(request.getDescription());
                newUser.setStatus(request.getStatus());
                newUser.setRole(findRole.get());

                // password
                String encodedPassword = passwordEncoder.encode(request.getPassword());
                newUser.setPassword(encodedPassword);

                userRepo.save(newUser);

                return new UserResponse(ResourceBundleConstant.USR_001, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.USR_001));
            }
            catch (Exception e) {
                return new UserResponse(ResourceBundleConstant.USR_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_002));
            }
        }
        else {
            return new UserResponse(ResourceBundleConstant.USR_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_002));
        }
    }

    @Override
    public UserResponse login(LoginRequest requestLogin) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestLogin.getUserName(), requestLogin.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();

            String token = jwtProvider.generateToken(customUserDetail);

            return new UserResponse(ResourceBundleConstant.USR_006, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.USR_006), token);

        } catch (BadCredentialsException e) {

            return new UserResponse(ResourceBundleConstant.USR_008, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_008));

        } catch (DisabledException e) {

            return new UserResponse(ResourceBundleConstant.USR_007, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_007));

        } catch (Exception e) {

            return new UserResponse(ResourceBundleConstant.USR_007, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_007));

        }
    }

    @Override
    public UserResponse getInfo(UUID idUser) {

        Optional<UserEntity> findInfo = userRepo.findById(idUser);
        if (findInfo.isPresent()) {
            return new UserResponse(ResourceBundleConstant.USR_004, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.USR_004), findInfo);
        }
        return new UserResponse(ResourceBundleConstant.USR_003, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_003));
    }

    @Override
    public UserResponse findAll() {

        List<UserEntity> findAll = userRepo.findAll();
        if (findAll.isEmpty()) {
            return new UserResponse(ResourceBundleConstant.USR_003, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_003));
        }
        return new UserResponse(ResourceBundleConstant.USR_004, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.USR_004), findAll);
    }

    @Override
    public UserResponse update(UpdateUserRequest updateUserRequest) {
        Optional<UserEntity> findInfo = userRepo.findById(updateUserRequest.getId());
        if (findInfo.isPresent()) {
            try {
                UserEntity userUpdate = findInfo.get();
                userUpdate.setUserName(updateUserRequest.getUserName());
                userUpdate.setDescription(updateUserRequest.getDescription());
                userRepo.save(userUpdate);
                return new UserResponse(ResourceBundleConstant.USR_009, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.USR_009));
            } catch (Exception e) {
                return new UserResponse(ResourceBundleConstant.USR_010, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_010));
            }
        }
        return new UserResponse(ResourceBundleConstant.USR_010, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.USR_010));
    }
}
