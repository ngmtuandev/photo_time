package photo_time_tracking.photo_time.service.implement_service;

import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.request.machine.CreateMachineRequest;
import photo_time_tracking.photo_time.dto.response.machine.MachineResponse;
import photo_time_tracking.photo_time.entity.MachineEntity;
import photo_time_tracking.photo_time.entity.StoreEntity;
import photo_time_tracking.photo_time.repositories.IMachineRepo;
import photo_time_tracking.photo_time.repositories.IStoreRepo;
import photo_time_tracking.photo_time.service.interface_service.IMachineService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;

import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements IMachineService {

    private final IMachineRepo machineRepo;

    private final IStoreRepo storeRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    public MachineServiceImpl(IStoreRepo storeRepo, IMachineRepo machineRepo, BaseAmenityUtil baseAmenityUtil) {
        this.machineRepo = machineRepo;
        this.baseAmenityUtil = baseAmenityUtil;
        this.storeRepo = storeRepo;
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }

    @Override
    public MachineResponse create(CreateMachineRequest requestCreateInfo) {

        Optional<MachineEntity> findMachineExist = machineRepo.findByCodeMachine(requestCreateInfo.getCodeMachine());
        if (findMachineExist.isPresent()) {
            return new MachineResponse(ResourceBundleConstant.MACHINE_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.MACHINE_002));
        }
        else {
            try {
                MachineEntity newMachine = new MachineEntity();
                newMachine.setCodeMachine(requestCreateInfo.getCodeMachine());

                Optional<StoreEntity> findStore = storeRepo.findById(requestCreateInfo.getStore());
                newMachine.setStore(findStore.get());

                try {
                    machineRepo.save(newMachine);
                    return new MachineResponse(ResourceBundleConstant.MACHINE_001, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.MACHINE_001));
                } catch (Exception e) {
                    return new MachineResponse(ResourceBundleConstant.MACHINE_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.MACHINE_002));
                }

            } catch (Exception e) {
                return new MachineResponse(ResourceBundleConstant.MACHINE_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.MACHINE_002));
            }
        }
    }

    @Override
    public MachineResponse findAll() {
        try {
            List<MachineEntity> findAll = machineRepo.findAll();
            return new MachineResponse(ResourceBundleConstant.MACHINE_003, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.MACHINE_003), findAll);
        } catch (Exception e) {
            return new MachineResponse(ResourceBundleConstant.MACHINE_004, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.MACHINE_004));
        }
    }
}
