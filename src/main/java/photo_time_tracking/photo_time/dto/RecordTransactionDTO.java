package photo_time_tracking.photo_time.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import photo_time_tracking.photo_time.enums.ETypeTransaction;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordTransactionDTO {

    private UUID id;

    private ETypeTransaction typeTransaction;

    private String imageEvident;

    private StoreDTO store;

    private UserDTO user;

    private SolutionDTO solution;

    private MachineDTO machine;

    private ResultDTO result;

    public void setMachine(MachineDTO machine) {
        this.machine = machine;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public MachineDTO getMachine() {
        return machine;
    }

    public ResultDTO getResult() {
        return result;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ETypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(ETypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getImageEvident() {
        return imageEvident;
    }

    public void setImageEvident(String imageEvident) {
        this.imageEvident = imageEvident;
    }

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public SolutionDTO getSolution() {
        return solution;
    }

    public void setSolution(SolutionDTO solution) {
        this.solution = solution;
    }


}
