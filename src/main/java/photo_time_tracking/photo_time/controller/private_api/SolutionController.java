package photo_time_tracking.photo_time.controller.private_api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.SolutionConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.role.RoleRequest;
import photo_time_tracking.photo_time.dto.request.solution.CreateSolutionRequest;
import photo_time_tracking.photo_time.dto.request.solution.UpdateSolutionRequest;
import photo_time_tracking.photo_time.dto.response.role.RoleResponse;
import photo_time_tracking.photo_time.dto.response.solution.SolutionResponse;
import photo_time_tracking.photo_time.service.implement_service.RoleServiceImpl;
import photo_time_tracking.photo_time.service.implement_service.SolutionServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + SolutionConstant.API_SOLUTION)
@Validated
public class SolutionController {

    @Autowired
    SolutionServiceImpl solutionService;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SolutionResponse> create(@RequestBody CreateSolutionRequest createSolutionRequest) {
        SolutionResponse response = solutionService.create(createSolutionRequest);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SolutionResponse> update(@RequestBody UpdateSolutionRequest updateSolutionRequest) {
        SolutionResponse response = solutionService.update(updateSolutionRequest);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SolutionResponse> delete(@RequestParam UUID solution_id) {
        SolutionResponse response = solutionService.delete(solution_id);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }


}
