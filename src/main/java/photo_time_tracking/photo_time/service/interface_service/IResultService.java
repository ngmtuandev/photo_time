package photo_time_tracking.photo_time.service.interface_service;
import photo_time_tracking.photo_time.dto.request.result.CreateResultRequest;
import photo_time_tracking.photo_time.dto.response.result.ResultResponse;

public interface IResultService {

    ResultResponse create(CreateResultRequest requestCreateInfo);

    ResultResponse findAll();
}
