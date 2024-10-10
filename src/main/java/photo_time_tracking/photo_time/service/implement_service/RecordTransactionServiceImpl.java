package photo_time_tracking.photo_time.service.implement_service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.constant.ResourceBundleConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.*;
import photo_time_tracking.photo_time.dto.request.record_transaction.CreateRecordTransaction;
import photo_time_tracking.photo_time.dto.response.record_transaction.RecordTransactionRespone;
import photo_time_tracking.photo_time.entity.*;
import photo_time_tracking.photo_time.repositories.*;
import photo_time_tracking.photo_time.service.interface_service.IRecordTransactionService;
import photo_time_tracking.photo_time.utils.BaseAmenityUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordTransactionServiceImpl implements IRecordTransactionService {

    private final IRecordTransactionRepo recordTransactionRepo;

    private final IStoreRepo storeRepo;

    private final IUserRepo userRepo;

    private final ISolutionRepo solutionRepo;

    private final IResultRepo resultRepo;

    private final IMachineRepo machineRepo;

    private final BaseAmenityUtil baseAmenityUtil;

    public RecordTransactionServiceImpl(IMachineRepo machineRepo, IRecordTransactionRepo recordTransactionRepo, BaseAmenityUtil baseAmenityUtil,
                                        IStoreRepo storeRepo, IUserRepo userRepo, ISolutionRepo solutionRepo, IResultRepo resultRepo) {
        this.recordTransactionRepo = recordTransactionRepo;
        this.baseAmenityUtil = baseAmenityUtil;
        this.userRepo = userRepo;
        this.storeRepo = storeRepo;
        this.solutionRepo = solutionRepo;
        this.resultRepo = resultRepo;
        this.machineRepo = machineRepo;
    }

    private String getMessageBundle(String key) {
        return baseAmenityUtil.getMessageBundle(key);
    }

    @Override
    public RecordTransactionRespone create(CreateRecordTransaction requestCreateInfo) {

            RecordTransactionEntity newRecord = new RecordTransactionEntity();

            if (requestCreateInfo.getSolution() != null) {
                Optional<SolutionEntity> solution = solutionRepo.findById(requestCreateInfo.getSolution());
                if (solution.isPresent()) {
                    newRecord.setSolution(solution.get());
                }
                else {
                    return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_002));
                }
            }

            if (requestCreateInfo.getUser() != null) {
                Optional<UserEntity> user = userRepo.findById(requestCreateInfo.getUser());
                if (user.isPresent()) {
                    newRecord.setUser(user.get());
                }
                else {
                    return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_002));
                }
            }

            if (requestCreateInfo.getStore() != null) {
                Optional<StoreEntity> store = storeRepo.findById(requestCreateInfo.getStore());
                if (store.isPresent()) {
                    newRecord.setStore(store.get());
                }
                else {
                    return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_002));
                }
            }

            if (requestCreateInfo.getResult() != null) {
                Optional<ResultEntity> result = resultRepo.findById(requestCreateInfo.getResult());
                if (result.isPresent()) {
                    newRecord.setResult(result.get());
                }
                else {
                    return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_002));
                }
            }

            if (requestCreateInfo.getMachine() != null) {
                Optional<MachineEntity> machine = machineRepo.findById(requestCreateInfo.getMachine());
                if (machine.isPresent()) {
                    newRecord.setMachine(machine.get());
                }
                else {
                    return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_002));
                }
            }

            newRecord.setSuccess(requestCreateInfo.getSuccess());
            newRecord.setTypeTransaction(requestCreateInfo.getTypeTransaction());
            newRecord.setImageEvident(requestCreateInfo.getImageEvident());
            newRecord.setMoney(requestCreateInfo.getMoney());

            try {
                recordTransactionRepo.save(newRecord);
                return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_001, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.RCTRANS_001), newRecord);
            } catch (Exception e) {
                return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_002, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_002));
            }
    }

    @Override
    public RecordTransactionRespone findAll(PaginationDTO filterInfo) {
        try {
            PageRequest pageable = PageRequest.of(filterInfo.getPage(), filterInfo.getSize());

            Page<RecordTransactionEntity> findAll = recordTransactionRepo.findAll(pageable);

            Integer totalPage = findAll.getTotalPages();

            List<RecordTransactionDTO> recordDTOs = findAll.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_003, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.RCTRANS_003), recordDTOs, filterInfo.getPage(), totalPage);
        } catch (Exception e) {
            return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_004, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_004));
        }
    }

    private RecordTransactionDTO convertToDTO(RecordTransactionEntity record) {

        RecordTransactionDTO dto = new RecordTransactionDTO();
        dto.setId(record.getId());
        dto.setTypeTransaction(record.getTypeTransaction());
        dto.setImageEvident(record.getImageEvident());
        dto.setStore(new StoreDTO(record.getStore().getStoreName(), record.getStore().getStoreCode(), record.getStore().getId()));
        dto.setSolution(new SolutionDTO(record.getSolution().getName(), record.getSolution().getDescription()));
        dto.setUser(new UserDTO(record.getUser().getUserName(), record.getUser().getDescription(), record.getUser().getId()));
        if (record.getResult() != null) {
            dto.setResult(new ResultDTO(record.getResult().getTypeResult(), record.getResult().getId()));
        }
        dto.setMachine(new MachineDTO(record.getMachine().getStore(), record.getMachine().getCodeMachine(), record.getStore().getId()));
        return dto;
    }

    @Override
    public RecordTransactionRespone findAllWithFilter(String storeCode, int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<RecordTransactionEntity> findAll = recordTransactionRepo.findRecordByCondition(storeCode, pageable);

            Integer totalPage = findAll.getTotalPages();

            List<RecordTransactionDTO> recordDTOs = findAll.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_003, SystemConstant.STATUS_CODE_SUCCESS, getMessageBundle(ResourceBundleConstant.RCTRANS_003), recordDTOs, page, totalPage);
        } catch (Exception e) {
            return new RecordTransactionRespone(ResourceBundleConstant.RCTRANS_004, SystemConstant.STATUS_CODE_BAD_REQUEST, getMessageBundle(ResourceBundleConstant.RCTRANS_004));
        }
    }
}
