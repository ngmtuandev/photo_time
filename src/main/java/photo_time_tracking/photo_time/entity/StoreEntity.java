package photo_time_tracking.photo_time.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
@Data
@Entity

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONTRUCTOR...)
public class StoreEntity extends BaseEntity{

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "store_code", unique = true, nullable = false)
    private String storeCode;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserEntity> users;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RecordTransactionEntity> records;

    public String getStoreCode() {
        return storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public Set<RecordTransactionEntity> getRecords() {
        return records;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setRecords(Set<RecordTransactionEntity> records) {
        this.records = records;
    }
}
