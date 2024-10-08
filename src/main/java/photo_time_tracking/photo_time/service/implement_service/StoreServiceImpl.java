package photo_time_tracking.photo_time.service.implement_service;
import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.IdDTO;
import photo_time_tracking.photo_time.dto.request.store.CreateStoreRequest;
import photo_time_tracking.photo_time.dto.request.store.UpdateStoreRequest;
import photo_time_tracking.photo_time.dto.response.store.StoreResponse;
import photo_time_tracking.photo_time.entity.StoreEntity;
import photo_time_tracking.photo_time.repositories.IStoreRepo;
import photo_time_tracking.photo_time.service.interface_service.IStoreService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements IStoreService {

    private IStoreRepo storeRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    public StoreServiceImpl(IStoreRepo storeRepo, BaseAmenityUtil baseAmenityUtil) {
        this.storeRepo = storeRepo;
        this.baseAmenityUtil = baseAmenityUtil;
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }

    @Override
    public StoreResponse create(CreateStoreRequest request) {

//        StoreEntity existingStore = storeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
        Optional<StoreEntity> findStoreExist = storeRepo.findByStoreCode(request.getStoreCode());
        if (findStoreExist.isPresent()) {
            return new StoreResponse(ResourceBundleConstant.STORE_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_002));
        }

        StoreEntity newStore = new StoreEntity();
        // TODO: CAN NOT USE BUILDER
        try {
            newStore.setStoreCode(request.getStoreCode());
            newStore.setStoreName(request.getStoreName());

            storeRepo.save(newStore);
            return new StoreResponse(ResourceBundleConstant.STORE_001, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.STORE_001));
        } catch (Exception e) {
            return new StoreResponse(ResourceBundleConstant.STORE_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_002));
        }
    }

    @Override
    public StoreResponse delete(IdDTO idDelete) {

//        StoreEntity existingStore = storeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
        Optional<StoreEntity> findStore = storeRepo.findById(idDelete.getId());
        if (!findStore.isPresent()) {
            return new StoreResponse(ResourceBundleConstant.STORE_006, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_006));
        }

        try {
            storeRepo.delete(findStore.get());
            return new StoreResponse(ResourceBundleConstant.STORE_005, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_005));

        } catch (Exception e) {
            return new StoreResponse(ResourceBundleConstant.STORE_006, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_006));
        }
    }

    @Override
    public StoreResponse findAll() {

        try {
            List<StoreEntity> findAll = storeRepo.findAll();
            return new StoreResponse(ResourceBundleConstant.STORE_003, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.STORE_003), findAll);

        } catch (Exception e) {
            return new StoreResponse(ResourceBundleConstant.STORE_004, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_004));
        }
    }

    @Override
    public StoreResponse update(UpdateStoreRequest updateInfo) {

//        StoreEntity existingStore = storeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
        Optional<StoreEntity> findStoreExist = storeRepo.findByStoreCode(updateInfo.getStoreCode());
        if (!findStoreExist.isPresent()) {
            return new StoreResponse(ResourceBundleConstant.STORE_007, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_007));
        }
        findStoreExist.get().setStoreName(updateInfo.getStoreName());
        findStoreExist.get().setStoreCode(updateInfo.getStoreCode());
        storeRepo.save(findStoreExist.get());
        return new StoreResponse(ResourceBundleConstant.STORE_008, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.STORE_008));
    }
}
