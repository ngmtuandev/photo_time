package photo_time_tracking.photo_time.controller.private_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.ResultConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.result.CreateResultRequest;
import photo_time_tracking.photo_time.dto.response.result.ResultResponse;
import photo_time_tracking.photo_time.service.implement_service.ResultServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + ResultConstant.API_RESULT)
@Validated
public class ResultController {

    @Autowired
    ResultServiceImpl resultService;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResultResponse> create(@RequestBody CreateResultRequest createResultInfo) {
        ResultResponse response = resultService.create(createResultInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
