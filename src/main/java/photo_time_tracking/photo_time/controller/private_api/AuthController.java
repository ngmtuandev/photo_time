package photo_time_tracking.photo_time.controller.private_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.constant.UserConstant;
import photo_time_tracking.photo_time.dto.request.user.RegisterRequest;
import photo_time_tracking.photo_time.dto.response.user.UserResponse;
import photo_time_tracking.photo_time.service.implement_service.UserServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + UserConstant.API_USER)
@Validated
public class AuthController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerInfo) {
        UserResponse response = userService.register(registerInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
