package photo_time_tracking.photo_time.service.implement_service;
import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.solution.CreateSolutionRequest;
import photo_time_tracking.photo_time.dto.request.solution.UpdateSolutionRequest;
import photo_time_tracking.photo_time.dto.response.solution.SolutionResponse;
import photo_time_tracking.photo_time.entity.SolutionEntity;
import photo_time_tracking.photo_time.repositories.ISolutionRepo;
import photo_time_tracking.photo_time.service.interface_service.ISolutionService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SolutionServiceImpl implements ISolutionService {

    private ISolutionRepo solutionRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    public SolutionServiceImpl(ISolutionRepo solutionRepo, BaseAmenityUtil baseAmenityUtil) {
        this.solutionRepo = solutionRepo;
        this.baseAmenityUtil = baseAmenityUtil;
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }

    @Override
    public SolutionResponse create(CreateSolutionRequest request) {

        Optional<SolutionEntity> findSolutionExist = solutionRepo.findByName(request.getName());
        if (findSolutionExist.isPresent()) {
            return new SolutionResponse(ResourceBundleConstant.SOLUTION_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_002));
        }
        else {
            try {
                SolutionEntity newSolution = new SolutionEntity();
                newSolution.setDescription(request.getDescription());
                newSolution.setName(request.getName());

                solutionRepo.save(newSolution);
                return new SolutionResponse(ResourceBundleConstant.SOLUTION_001, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.SOLUTION_001));
            } catch (Exception e) {
                return new SolutionResponse(ResourceBundleConstant.SOLUTION_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_002));
            }
        }
    }

    @Override
    public SolutionResponse delete(UUID idDelete) {
        Optional<SolutionEntity> findSolutionExist = solutionRepo.findById(idDelete);
        if (findSolutionExist.isPresent()) {
            try {
                solutionRepo.delete(findSolutionExist.get());
                return new SolutionResponse(ResourceBundleConstant.SOLUTION_005, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.SOLUTION_005));
            } catch (Exception e) {
                return new SolutionResponse(ResourceBundleConstant.SOLUTION_006, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_006));
            }
        }
        return new SolutionResponse(ResourceBundleConstant.SOLUTION_006, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_006));
    }

    @Override
    public SolutionResponse findAll() {
        try {
            List<SolutionEntity> findAll = solutionRepo.findAll();
            return new SolutionResponse(ResourceBundleConstant.SOLUTION_003, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.SOLUTION_003), findAll);
        } catch (Exception e) {
            return new SolutionResponse(ResourceBundleConstant.SOLUTION_004, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.SOLUTION_004));
        }
    }

    @Override
    public SolutionResponse update(UpdateSolutionRequest updateInfo) {

        Optional<SolutionEntity> findSolutionExist = solutionRepo.findById(updateInfo.getId());
        if(findSolutionExist.isPresent()) {
            try {
                SolutionEntity solutionUpdate = findSolutionExist.get();
                solutionUpdate.setName(updateInfo.getName());
                solutionUpdate.setDescription(updateInfo.getDescription());
                solutionRepo.save(solutionUpdate);
                return new SolutionResponse(ResourceBundleConstant.SOLUTION_008, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.SOLUTION_008));
            } catch (Exception e) {
                return new SolutionResponse(ResourceBundleConstant.SOLUTION_007, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_007));
            }
        } else {
            return new SolutionResponse(ResourceBundleConstant.SOLUTION_007, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_007));
        }
    }

    @Override
    public SolutionResponse getOne(UUID idSolution) {

        try {
            Optional<SolutionEntity> findSolution = solutionRepo.findById(idSolution);
            if (findSolution.isPresent()) {
                return new SolutionResponse(ResourceBundleConstant.SOLUTION_009, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.SOLUTION_009), findSolution.get());
            }
        } catch (Exception e) {
            return new SolutionResponse(ResourceBundleConstant.SOLUTION_010, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_010));
        }
        return new SolutionResponse(ResourceBundleConstant.SOLUTION_010, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.SOLUTION_010));
    }
}
