package photo_time_tracking.photo_time.service.interface_service;
import photo_time_tracking.photo_time.dto.PaginationDTO;
import photo_time_tracking.photo_time.dto.request.record_transaction.CreateRecordTransaction;
import photo_time_tracking.photo_time.dto.response.record_transaction.RecordTransactionRespone;

public interface IRecordTransactionService {

    RecordTransactionRespone create(CreateRecordTransaction requestCreateInfo);

    RecordTransactionRespone findAll(PaginationDTO paginationDTO);

    RecordTransactionRespone findAllWithFilter(String storeCode, int page, int size);
}
