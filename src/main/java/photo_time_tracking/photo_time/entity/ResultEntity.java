package photo_time_tracking.photo_time.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "result")
@Data
@Entity
// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONSTRUCTOR...)
public class ResultEntity extends BaseEntity{

    @Column(name = "type_result", nullable = false)
    private String typeResult;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordTransactionEntity> recordTransactions;

    @Override
    public UUID getId() {
        return super.getId();
    }

    public void setRecordTransactions(List<RecordTransactionEntity> recordTransactions) {
        this.recordTransactions = recordTransactions;
    }

    public List<RecordTransactionEntity> getRecordTransactions() {
        return recordTransactions;
    }

    public String getTypeResult() {
        return typeResult;
    }

    public void setTypeResult(String typeResult) {
        this.typeResult = typeResult;
    }
}
