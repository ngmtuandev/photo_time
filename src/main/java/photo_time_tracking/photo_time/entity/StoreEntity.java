package photo_time_tracking.photo_time.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "users")
@Table(name = "store")
@Data
@Entity

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONSTRUCTOR...)
public class StoreEntity extends BaseEntity{

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "store_code", unique = true, nullable = false)
    private String storeCode;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserEntity> users;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecordTransactionEntity> records;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MachineEntity> machines;

    public String getStoreCode() {
        return storeCode;
    }

    public List<MachineEntity> getMachines() {
        return machines;
    }

    public String getStoreName() {
        return storeName;
    }

    public List<RecordTransactionEntity> getRecords() {
        return records;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setRecords(List<RecordTransactionEntity> records) {
        this.records = records;
    }

    public void setMachines(List<MachineEntity> machines) {
        this.machines = machines;
    }
}
