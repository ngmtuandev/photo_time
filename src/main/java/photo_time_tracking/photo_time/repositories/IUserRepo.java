package photo_time_tracking.photo_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.UserEntity;

import java.util.UUID;

public interface IUserRepo extends JpaRepository<UserEntity, UUID> {

    UserEntity findByUserName(String userName);

    boolean existsByUserName(String userName);
}
