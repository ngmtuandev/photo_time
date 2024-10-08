package photo_time_tracking.photo_time.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "error")
@Data
@Entity

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONSTRUCTOR...)
public class ErrorEntity extends BaseEntity{

    @Column(name = "error_code", nullable = false)
    private String errorCode;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "error", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordTransactionEntity> recordTransactions;

    // TODO: FIX LONBOK AUTO GETTER / SETTER
    // Getter

    public List<RecordTransactionEntity> getRecordTransactions() {
        return recordTransactions;
    }

    public String getDescription() {
        return description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    // setter

    public void setRecordTransactions(List<RecordTransactionEntity> recordTransactions) {
        this.recordTransactions = recordTransactions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
