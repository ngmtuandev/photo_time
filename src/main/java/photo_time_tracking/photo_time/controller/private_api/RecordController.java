package photo_time_tracking.photo_time.controller.private_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.RecordTransactionConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.dto.PaginationDTO;
import photo_time_tracking.photo_time.dto.request.record_transaction.CreateRecordTransaction;
import photo_time_tracking.photo_time.dto.response.record_transaction.RecordTransactionRespone;
import photo_time_tracking.photo_time.service.implement_service.RecordTransactionServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + RecordTransactionConstant.API_RECORD_TRANSACTION)
@Validated
public class RecordController {

    @Autowired
    RecordTransactionServiceImpl recordTransactionService;

    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<RecordTransactionRespone> create(@RequestBody CreateRecordTransaction createRecordInfo) {
        RecordTransactionRespone response = recordTransactionService.create(createRecordInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<RecordTransactionRespone> findAll(@ModelAttribute PaginationDTO paginationInfo) {
        RecordTransactionRespone response = recordTransactionService.findAll(paginationInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(RecordTransactionConstant.API_FILTER)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<RecordTransactionRespone> findFilter(@RequestParam(required = false) String storeCode, @RequestParam(required = false) String machineCode,
                                                               @RequestParam(required = false) int page, @RequestParam(required = false) int size
                                                               ) {
        RecordTransactionRespone response = recordTransactionService.findAllWithFilter(storeCode, page, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
