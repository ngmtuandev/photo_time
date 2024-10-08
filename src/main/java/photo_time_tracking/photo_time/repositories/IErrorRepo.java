package photo_time_tracking.photo_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.ErrorEntity;

import java.util.Optional;
import java.util.UUID;

public interface IErrorRepo extends JpaRepository<ErrorEntity, UUID> {

    Optional<ErrorEntity> findByErrorCode(String errorCode);
}
