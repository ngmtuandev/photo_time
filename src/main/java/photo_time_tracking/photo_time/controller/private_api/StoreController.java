package photo_time_tracking.photo_time.controller.private_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.StoreConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.IdDTO;
import photo_time_tracking.photo_time.dto.request.store.CreateStoreRequest;
import photo_time_tracking.photo_time.dto.request.store.UpdateStoreRequest;
import photo_time_tracking.photo_time.dto.response.store.StoreResponse;
import photo_time_tracking.photo_time.service.implement_service.StoreServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + StoreConstant.API_STORE)
@Validated
public class StoreController {

    @Autowired
    StoreServiceImpl storeService;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StoreResponse> create(@RequestBody CreateStoreRequest storeCreateInfo) {
        StoreResponse response = storeService.create(storeCreateInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StoreResponse> findAll() {
        StoreResponse response = storeService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<StoreResponse> delete(@RequestBody IdDTO idStore) {
        StoreResponse response = storeService.delete(idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StoreResponse> update(@RequestBody UpdateStoreRequest updateStoreRequest) {
        StoreResponse response = storeService.update(updateStoreRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
