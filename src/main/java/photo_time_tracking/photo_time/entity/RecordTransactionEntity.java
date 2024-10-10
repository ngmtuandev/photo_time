package photo_time_tracking.photo_time.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import photo_time_tracking.photo_time.enums.ETypeTransaction;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "store", "solution", "error"})
@Table(name = "record_transaction")
@Data
@Entity

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONSTRUCTOR...)
public class RecordTransactionEntity extends BaseEntity {

    @Column(name = "type_transaction", nullable = false)
    private ETypeTransaction typeTransaction;

    @Column(name = "is_success", nullable = false)
    private Boolean isSuccess;

    @Column(name = "image_evident", nullable = false)
    private String imageEvident;

    @Column(name = "money", nullable = false)
    private Number money;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @JsonIgnore
    private StoreEntity store;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solution_id", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private SolutionEntity solution;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "result_id", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private ResultEntity result;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @JsonIgnore
    private MachineEntity machine; // Record liên kết với một Machine

    // Getter
    // TODO: FIX LOMBOK AUTO CREATE CONTRUCTOR
    public ETypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public String getImageEvident() {
        return imageEvident;
    }


    public StoreEntity getStore() {
        return store;
    }

    public SolutionEntity getSolution() {
        return solution;
    }

    public UserEntity getUser() {
        return user;
    }

    public ResultEntity getResult() {
        return result;
    }

    public Number getMoney() {
        return money;
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    // Setter
    // TODO: FIX LOMBOK AUTO CREATE CONTRUCTOR, GETTER, SETTER

    public void setImageEvident(String imageEvident) {
        this.imageEvident = imageEvident;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public void setTypeTransaction(ETypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public void setSolution(SolutionEntity solution) {
        this.solution = solution;
    }

    public MachineEntity getMachine() {
        return machine;
    }

    public void setMachine(MachineEntity machine) {
        this.machine = machine;
    }

    public void setMoney(Number money) {
        this.money = money;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }
}
