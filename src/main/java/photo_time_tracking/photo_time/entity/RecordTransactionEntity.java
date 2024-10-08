package photo_time_tracking.photo_time.entity;

import jakarta.persistence.*;
import lombok.*;
import photo_time_tracking.photo_time.enums.ETypeTransaction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "record_transaction")
@Data
@Entity

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONSTRUCTOR...)
public class RecordTransactionEntity extends BaseEntity {

    @Column(name = "store_name", nullable = false)
    private ETypeTransaction typeTransaction;

    @Column(name = "is_success", nullable = false)
    private Boolean isSuccess;

    @Column(name = "image_evident", nullable = false)
    private String imageEvident;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private StoreEntity store;

    @ManyToOne
    @JoinColumn(name = "solution_id", referencedColumnName = "id", nullable = true)
    private SolutionEntity solution;

    @ManyToOne
    @JoinColumn(name = "error_id", referencedColumnName = "id", nullable = true)
    private ErrorEntity error;


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

    public ErrorEntity getError() {
        return error;
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

    public void setError(ErrorEntity error) {
        this.error = error;
    }
}
