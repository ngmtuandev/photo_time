package photo_time_tracking.photo_time.service.interface_service;
import photo_time_tracking.photo_time.dto.IdDTO;
import photo_time_tracking.photo_time.dto.request.error.CreateErrorRequest;
import photo_time_tracking.photo_time.dto.request.error.UpdateErrorRequest;
import photo_time_tracking.photo_time.dto.response.error.ErrorResponse;

import java.util.UUID;

public interface IErrorService {

    ErrorResponse create(CreateErrorRequest request);

    ErrorResponse delete(UUID idDelete);

    ErrorResponse findAll();

    ErrorResponse update(UpdateErrorRequest updateInfo);

    ErrorResponse getOne(UUID idError);

}
