package photo_time_tracking.photo_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.ResultEntity;

import java.util.Optional;
import java.util.UUID;

public interface IResultRepo extends JpaRepository<ResultEntity, UUID> {

    Optional<ResultEntity> findByTypeResult(String typeResult);

}
