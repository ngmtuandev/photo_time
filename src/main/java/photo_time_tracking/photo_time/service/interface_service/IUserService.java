package photo_time_tracking.photo_time.service.interface_service;

import photo_time_tracking.photo_time.dto.request.user.LoginRequest;
import photo_time_tracking.photo_time.dto.request.user.RegisterRequest;
import photo_time_tracking.photo_time.dto.response.user.UserResponse;
import photo_time_tracking.photo_time.entity.UserEntity;

public interface IUserService {

    UserEntity findByUserName(String userName);

    boolean existsByUserName(String userName);

    UserResponse register(RegisterRequest request);

    UserResponse login(LoginRequest requestLogin);

}
