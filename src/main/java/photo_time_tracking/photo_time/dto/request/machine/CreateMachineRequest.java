package photo_time_tracking.photo_time.dto.request.machine;

import jakarta.persistence.*;
import lombok.Data;
import photo_time_tracking.photo_time.entity.RecordTransactionEntity;
import photo_time_tracking.photo_time.entity.StoreEntity;

import java.util.List;
import java.util.UUID;

@Data
// TODO: FIX ERROR LOMBOK NOT USE AUTO CONSTRUCTOR
public class CreateMachineRequest {

    private String codeMachine;

    private UUID store;

    public void setCodeMachine(String codeMachine) {
        this.codeMachine = codeMachine;
    }

    public String getCodeMachine() {
        return codeMachine;
    }

    public UUID getStore() {
        return store;
    }

    public void setStore(UUID store) {
        this.store = store;
    }
}
