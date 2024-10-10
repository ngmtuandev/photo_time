package photo_time_tracking.photo_time.service.interface_service;
import photo_time_tracking.photo_time.dto.request.machine.CreateMachineRequest;
import photo_time_tracking.photo_time.dto.response.machine.MachineResponse;

public interface IMachineService {

    MachineResponse create(CreateMachineRequest requestCreateInfo);

    MachineResponse findAll();
}
