package photo_time_tracking.photo_time.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "store")
@Table(name = "machine")
@Data
@Entity
public class MachineEntity extends BaseEntity {

    @Column(name = "code_machine", nullable = false)
    private String codeMachine;

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RecordTransactionEntity> records;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private StoreEntity store;

    public String getCodeMachine() {
        return codeMachine;
    }

    public void setCodeMachine(String codeMachine) {
        this.codeMachine = codeMachine;
    }

    public List<RecordTransactionEntity> getRecords() {
        return records;
    }

    public void setRecords(List<RecordTransactionEntity> records) {
        this.records = records;
    }

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }
}
