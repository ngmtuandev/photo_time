package photo_time_tracking.photo_time.controller.public_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import photo_time_tracking.photo_time.constant.RecordTransactionConstant;
import photo_time_tracking.photo_time.constant.SystemConstant;
import photo_time_tracking.photo_time.service.implement_service.RecordTransactionServiceImpl;

@RestController
@RequestMapping(SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_USER + RecordTransactionConstant.API_RECORD_TRANSACTION)
@Validated
public class RecordTransactionController {

    @Autowired
    RecordTransactionServiceImpl recordTransactionService;

}
