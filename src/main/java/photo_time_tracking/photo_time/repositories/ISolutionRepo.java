package photo_time_tracking.photo_time.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.SolutionEntity;
import java.util.Optional;
import java.util.UUID;

public interface ISolutionRepo extends JpaRepository<SolutionEntity, UUID> {

    Optional<SolutionEntity> findByName(String nameSolution);

}
