package photo_time_tracking.photo_time.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "solution")
@Data
@Entity

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONSTRUCTOR...)
public class SolutionEntity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "solution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordTransactionEntity> recordTransactions;

    // TODO: FIX LONBOK AUTO GETTER / SETTER
    // GETTER

    public String getDescription() {
        return description;
    }

    public List<RecordTransactionEntity> getRecordTransactions() {
        return recordTransactions;
    }

    public String getName() {
        return name;
    }

    // SETTER

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecordTransactions(List<RecordTransactionEntity> recordTransactions) {
        this.recordTransactions = recordTransactions;
    }

    public void setName(String name) {
        this.name = name;
    }
}
