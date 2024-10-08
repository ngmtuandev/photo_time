package photo_time_tracking.photo_time.controller.private_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.ErrorConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.IdDTO;
import photo_time_tracking.photo_time.dto.request.error.CreateErrorRequest;
import photo_time_tracking.photo_time.dto.request.error.UpdateErrorRequest;
import photo_time_tracking.photo_time.dto.response.error.ErrorResponse;
import photo_time_tracking.photo_time.service.implement_service.ErrorServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + ErrorConstant.API_ERROR)
@Validated
public class ErrorController {

    @Autowired
    ErrorServiceImpl errorService;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ErrorResponse> create(@RequestBody CreateErrorRequest createErrorRequest) {
        ErrorResponse response = errorService.create(createErrorRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ErrorResponse> update(@RequestBody UpdateErrorRequest updateErrorRequest) {
        ErrorResponse response = errorService.update(updateErrorRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ErrorResponse> delete(@RequestParam UUID error_id) {
        ErrorResponse response = errorService.delete(error_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
