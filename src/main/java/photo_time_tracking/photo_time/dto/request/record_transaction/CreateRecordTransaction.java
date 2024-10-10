package photo_time_tracking.photo_time.dto.request.record_transaction;
import lombok.Data;
import photo_time_tracking.photo_time.enums.ETypeTransaction;

import java.util.UUID;

@Data
// TODO: FIX ERROR LOMBOK NOT USE AUTO CONSTRUCTOR
public class CreateRecordTransaction {

    private ETypeTransaction typeTransaction;

    private Boolean isSuccess;

    private String imageEvident;

    private UUID user;

    private UUID store;

    private UUID solution;

    private UUID result;

    private UUID machine;

    private Number money;

    public void setMoney(Number money) {
        this.money = money;
    }

    public Number getMoney() {
        return money;
    }

    public void setResult(UUID result) {
        this.result = result;
    }

    public void setMachine(UUID machine) {
        this.machine = machine;
    }

    public void setSolution(UUID solution) {
        this.solution = solution;
    }

    public UUID getSolution() {
        return solution;
    }

    public void setStore(UUID store) {
        this.store = store;
    }

    public UUID getStore() {
        return store;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public UUID getUser() {
        return user;
    }

    public void setTypeTransaction(ETypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public ETypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setImageEvident(String imageEvident) {
        this.imageEvident = imageEvident;
    }

    public String getImageEvident() {
        return imageEvident;
    }

    public UUID getMachine() {
        return machine;
    }

    public UUID getResult() {
        return result;
    }
}
