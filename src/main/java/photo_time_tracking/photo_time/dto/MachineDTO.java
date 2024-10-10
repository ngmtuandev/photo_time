package photo_time_tracking.photo_time.dto;

import photo_time_tracking.photo_time.entity.StoreEntity;

import java.util.UUID;

public class MachineDTO {

    private UUID idMachine;

    private String codeMachine;

    private StoreEntity store;

    public void setCodeMachine(String codeMachine) {
        this.codeMachine = codeMachine;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public UUID getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(UUID idMachine) {
        this.idMachine = idMachine;
    }

    public String getCodeMachine() {
        return codeMachine;
    }

    public StoreEntity getStore() {
        return store;
    }

    public MachineDTO(StoreEntity store, String codeMachine, UUID idMachine) {
        this.store = store;
        this.idMachine = idMachine;
        this.codeMachine = codeMachine;
    }
}
