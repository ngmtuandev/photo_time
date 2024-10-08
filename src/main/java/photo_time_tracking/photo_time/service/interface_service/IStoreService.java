package photo_time_tracking.photo_time.service.interface_service;
import photo_time_tracking.photo_time.dto.IdDTO;
import photo_time_tracking.photo_time.dto.request.store.CreateStoreRequest;
import photo_time_tracking.photo_time.dto.request.store.UpdateStoreRequest;
import photo_time_tracking.photo_time.dto.response.store.StoreResponse;

public interface IStoreService {

    StoreResponse create(CreateStoreRequest request);

    StoreResponse delete(IdDTO idDelete);

    StoreResponse findAll();

    StoreResponse update(UpdateStoreRequest updateInfo);

}
