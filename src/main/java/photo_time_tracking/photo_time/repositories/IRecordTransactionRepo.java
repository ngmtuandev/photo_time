package photo_time_tracking.photo_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.RecordTransactionEntity;

import java.util.UUID;

public interface IRecordTransactionRepo extends JpaRepository<RecordTransactionEntity, UUID> {
}
