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
import photo_time_tracking.photo_time.constant.MachineConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.machine.CreateMachineRequest;
import photo_time_tracking.photo_time.dto.response.machine.MachineResponse;
import photo_time_tracking.photo_time.service.implement_service.MachineServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + MachineConstant.API_MACHINE)
@Validated
public class MachineController {

    @Autowired
    MachineServiceImpl machineService;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MachineResponse> create(@RequestBody CreateMachineRequest createMachineRequest) {
        MachineResponse response = machineService.create(createMachineRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
