package photo_time_tracking.photo_time.entity;

import jakarta.persistence.*;
import lombok.*;
import photo_time_tracking.photo_time.enums.ERole;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
@Data
@Entity
public class RoleEntity extends BaseEntity {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ERole roleName;

}
