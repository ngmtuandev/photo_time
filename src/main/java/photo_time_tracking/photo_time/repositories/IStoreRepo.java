package photo_time_tracking.photo_time.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.StoreEntity;

import java.util.Optional;
import java.util.UUID;

public interface IStoreRepo extends JpaRepository<StoreEntity, UUID> {

    Optional<StoreEntity> findByStoreCode(String storeCode);
}
