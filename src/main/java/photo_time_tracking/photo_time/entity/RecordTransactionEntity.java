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

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONTRUCTOR...)
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

    public UserEntity getUser() {
        return user;
    }

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
}
