package photo_time_tracking.photo_time.service.interface_service;
import photo_time_tracking.photo_time.dto.request.solution.CreateSolutionRequest;
import photo_time_tracking.photo_time.dto.request.solution.UpdateSolutionRequest;
import photo_time_tracking.photo_time.dto.response.solution.SolutionResponse;

import java.util.UUID;

public interface ISolutionService {

    SolutionResponse create(CreateSolutionRequest request);

    SolutionResponse delete(UUID idDelete);

    SolutionResponse findAll();

    SolutionResponse update(UpdateSolutionRequest updateInfo);

    SolutionResponse getOne(UUID idSolution);
}
