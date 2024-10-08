package photo_time_tracking.photo_time.controller.public_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.ErrorConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.response.error.ErrorResponse;
import photo_time_tracking.photo_time.service.implement_service.ErrorServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_USER + ErrorConstant.API_ERROR)
@Validated
public class ErrorPublicController {

    @Autowired
    ErrorServiceImpl errorService;

    @GetMapping()
    public ResponseEntity<ErrorResponse> findAll() {
        ErrorResponse response = errorService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(ErrorConstant.API_ERROR_GET_ONE)
    public ResponseEntity<ErrorResponse> findOne(@RequestParam UUID error_id) {
        ErrorResponse response = errorService.getOne(error_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
