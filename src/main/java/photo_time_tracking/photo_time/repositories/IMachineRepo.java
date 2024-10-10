package photo_time_tracking.photo_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_time_tracking.photo_time.entity.MachineEntity;

import java.util.Optional;
import java.util.UUID;

public interface IMachineRepo extends JpaRepository<MachineEntity, UUID> {

    Optional<MachineEntity> findByCodeMachine(String codeMachine);
}
