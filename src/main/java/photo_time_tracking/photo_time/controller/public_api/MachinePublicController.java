package photo_time_tracking.photo_time.controller.public_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.MachineConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.response.machine.MachineResponse;
import photo_time_tracking.photo_time.service.implement_service.MachineServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_USER + MachineConstant.API_MACHINE)
@Validated
public class MachinePublicController {

    @Autowired
    MachineServiceImpl machineService;

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MachineResponse> findAll() {
        MachineResponse response = machineService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
