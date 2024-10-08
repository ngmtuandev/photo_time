package photo_time_tracking.photo_time.service.implement_service;
import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.IdDTO;
import photo_time_tracking.photo_time.dto.request.error.CreateErrorRequest;
import photo_time_tracking.photo_time.dto.request.error.UpdateErrorRequest;
import photo_time_tracking.photo_time.dto.response.error.ErrorResponse;
import photo_time_tracking.photo_time.entity.ErrorEntity;
import photo_time_tracking.photo_time.repositories.IErrorRepo;
import photo_time_tracking.photo_time.service.interface_service.IErrorService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ErrorServiceImpl implements IErrorService {

    private IErrorRepo errorRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    public ErrorServiceImpl(IErrorRepo errorRepo, BaseAmenityUtil baseAmenityUtil) {
        this.errorRepo = errorRepo;
        this.baseAmenityUtil = baseAmenityUtil;
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }

    @Override
    public ErrorResponse create(CreateErrorRequest request) {

        Optional<ErrorEntity> findErrorExist = errorRepo.findByErrorCode(request.getErrorCode());
        if (findErrorExist.isPresent()) {
            return new ErrorResponse(ResourceBundleConstant.ERROR_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_002));
        }
        ErrorEntity newError = new ErrorEntity();
        try {
            // TODO: CAN NOT USE BUILDER
            newError.setErrorCode(request.getErrorCode());
            newError.setDescription(request.getDescription());

            errorRepo.save(newError);
            return new ErrorResponse(ResourceBundleConstant.ERROR_001, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.ERROR_001));
        } catch (Exception e) {
            return new ErrorResponse(ResourceBundleConstant.ERROR_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_002));
        }

    }

    @Override
    public ErrorResponse delete(UUID idDelete) {

        Optional<ErrorEntity> findError = errorRepo.findById(idDelete);
        if (findError.isPresent()) {
            try {
                errorRepo.delete(findError.get());
                return new ErrorResponse(ResourceBundleConstant.ERROR_005, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.ERROR_005));
            } catch (Exception e) {
                return new ErrorResponse(ResourceBundleConstant.ERROR_006, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_006));
            }
        }
        return new ErrorResponse(ResourceBundleConstant.ERROR_006, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_006));
    }

    @Override
    public ErrorResponse findAll() {
        try {
            List<ErrorEntity> findAll = errorRepo.findAll();
            return new ErrorResponse(ResourceBundleConstant.ERROR_003, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.ERROR_003), findAll);
        } catch (Exception e) {
            return new ErrorResponse(ResourceBundleConstant.ERROR_004, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_004));
        }
    }

    @Override
    public ErrorResponse update(UpdateErrorRequest updateInfo) {
        Optional<ErrorEntity> findError = errorRepo.findById(updateInfo.getId());
        if (findError.isPresent()) {
            try {
                ErrorEntity errorUpdate = findError.get();
                errorUpdate.setDescription(updateInfo.getDescription());
                errorUpdate.setErrorCode(updateInfo.getErrorCode());
                errorRepo.save(errorUpdate);
                return new ErrorResponse(ResourceBundleConstant.ERROR_010, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.ERROR_010));
            } catch (Exception e) {
                return new ErrorResponse(ResourceBundleConstant.ERROR_009, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_009));
            }
        }
        return new ErrorResponse(ResourceBundleConstant.ERROR_009, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_009));
    }

    @Override
    public ErrorResponse getOne(UUID idError) {

        Optional<ErrorEntity> errorInfo = errorRepo.findById(idError);
        if (errorInfo.isPresent()) {
            return new ErrorResponse(ResourceBundleConstant.ERROR_008, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.ERROR_008), errorInfo.get());
        }
        return new ErrorResponse(ResourceBundleConstant.ERROR_007, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.ERROR_007));
    }
}
