package photo_time_tracking.photo_time.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"role", "store"})
@Table(name = "user")
@Data
@Entity
public class UserEntity extends BaseEntity {

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "description", nullable = true, unique = false)
    private String description;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private StoreEntity store;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RecordTransactionEntity> recordTransactions;

    public RoleEntity getRole() {
        return this.role;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getDescription() {
        return this.description;
    }

    public List<RecordTransactionEntity> getRecordTransactions() {
        return recordTransactions;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public StoreEntity getStore() {
        return this.store;
    }

    // TODO: FIX (LAMBOK) AUTO CREATE CONTRUCTOR, GETTER, SETTER

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecordTransactions(List<RecordTransactionEntity> recordTransactions) {
        this.recordTransactions = recordTransactions;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }
}
