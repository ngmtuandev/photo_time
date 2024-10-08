package photo_time_tracking.photo_time.controller.public_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.constant.UserConstant;
import photo_time_tracking.photo_time.dto.request.user.LoginRequest;
import photo_time_tracking.photo_time.dto.request.user.UpdateUserRequest;
import photo_time_tracking.photo_time.dto.response.user.UserResponse;
import photo_time_tracking.photo_time.service.implement_service.UserServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_USER + UserConstant.API_USER)
@Validated
public class AuthPublicController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping()
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginInfo) {
        UserResponse response = userService.login(loginInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<UserResponse> findAll() {
        UserResponse response = userService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(UserConstant.API_GET_PROFILE)
    public ResponseEntity<UserResponse> getInfo(@RequestParam UUID userId) {
        UserResponse response = userService.getInfo(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserResponse> updateInfo(@RequestBody UpdateUserRequest updateUserRequest) {
        UserResponse response = userService.update(updateUserRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
