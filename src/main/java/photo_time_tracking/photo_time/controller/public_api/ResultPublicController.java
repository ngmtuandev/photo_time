package photo_time_tracking.photo_time.controller.public_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.ResultConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.response.result.ResultResponse;
import photo_time_tracking.photo_time.service.implement_service.ResultServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_USER + ResultConstant.API_RESULT)
@Validated
public class ResultPublicController {

    @Autowired
    ResultServiceImpl resultService;

    @GetMapping()
    public ResponseEntity<ResultResponse> findAll() {
        ResultResponse response = resultService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
