package photo_time_tracking.photo_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.RoleEntity;

import java.util.UUID;

public interface IRoleRepo extends JpaRepository<RoleEntity, UUID> {
}
