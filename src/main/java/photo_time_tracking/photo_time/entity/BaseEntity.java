package photo_time_tracking.photo_time.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.Types;
import java.util.Date;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER (CONSTRUCTOR...)
public class BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(Types.VARCHAR)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Column(name = "is_delete", nullable = true)
    @ColumnDefault("false")
    private boolean isDelete;

    public UUID getId() {
        return id;
    }
}
