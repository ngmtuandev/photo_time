package photo_time_tracking.photo_time.service.implement_service;

import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.result.CreateResultRequest;
import photo_time_tracking.photo_time.dto.response.result.ResultResponse;
import photo_time_tracking.photo_time.entity.ResultEntity;
import photo_time_tracking.photo_time.repositories.*;
import photo_time_tracking.photo_time.service.interface_service.IResultService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements IResultService {

    private final IResultRepo resultRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    public ResultServiceImpl(BaseAmenityUtil baseAmenityUtil, IResultRepo resultRepo) {
        this.baseAmenityUtil = baseAmenityUtil;
        this.resultRepo = resultRepo;
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }

    @Override
    public ResultResponse create(CreateResultRequest requestCreateInfo) {

        Optional<ResultEntity> findResult = resultRepo.findByTypeResult(requestCreateInfo.getTypeResult());
        if (findResult.isPresent()) {
            return new ResultResponse(ResourceBundleConstant.RESULT_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RESULT_002));
        }
        else {
            ResultEntity newResult = new ResultEntity();
            newResult.setTypeResult(requestCreateInfo.getTypeResult());

            try {
                resultRepo.save(newResult);
                return new ResultResponse(ResourceBundleConstant.RESULT_001, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.RESULT_001), newResult);
            } catch (Exception e) {
                return new ResultResponse(ResourceBundleConstant.RESULT_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RESULT_002));
            }
        }
    }

    @Override
    public ResultResponse findAll() {
        try {
            List<ResultEntity> findAll = resultRepo.findAll();
            return new ResultResponse(ResourceBundleConstant.RESULT_003, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.RESULT_003), findAll);
        } catch (Exception e) {
            return new ResultResponse(ResourceBundleConstant.RESULT_004, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RESULT_004));
        }
    }
}
