package photo_time_tracking.photo_time.controller.public_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.SolutionConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.response.solution.SolutionResponse;
import photo_time_tracking.photo_time.service.implement_service.SolutionServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_USER + SolutionConstant.API_SOLUTION)
@Validated
public class SolutionPublicController {

    @Autowired
    SolutionServiceImpl solutionService;

    @GetMapping()
    public ResponseEntity<SolutionResponse> findAll() {
        SolutionResponse response = solutionService.findAll();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(SolutionConstant.API_SOLUTION_FIND_ONE)
    public ResponseEntity<SolutionResponse> findOne(@RequestParam UUID solution_id) {
        SolutionResponse response = solutionService.getOne(solution_id);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}