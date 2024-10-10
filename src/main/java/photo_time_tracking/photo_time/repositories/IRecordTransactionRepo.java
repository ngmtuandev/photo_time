package photo_time_tracking.photo_time.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import photo_time_tracking.photo_time.entity.RecordTransactionEntity;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface IRecordTransactionRepo extends JpaRepository<RecordTransactionEntity, UUID> {

    @EntityGraph(attributePaths = {"user", "store", "error", "solution", "result", "machine"})
    List<RecordTransactionEntity> findAll();

    @Query("""
    SELECT r FROM RecordTransactionEntity r
    LEFT JOIN r.store s
    LEFT JOIN s.users u
    WHERE s.storeCode = :storeCode
    """)
    Page<RecordTransactionEntity> findRecordByCondition(@Param("storeCode") String storeCode, Pageable pageable);

/*
@Query("""
    SELECT r FROM RecordTransactionEntity r
    LEFT JOIN r.store s
    LEFT JOIN s.users u
    LEFT JOIN machine m ON m.store = s
    WHERE s.storeCode = :storeCode
    WHERE (:storeCode IS NULL OR s.storeCode = :storeCode)
    AND m.id = :machineCode
    """)
* */
}
