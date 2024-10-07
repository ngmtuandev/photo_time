package photo_time_tracking.photo_time.entity;

import jakarta.persistence.*;
import lombok.*;
import photo_time_tracking.photo_time.enums.ERole;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
@Data
@Entity

// TODO: FIX LOMBOK NOT CAN CREATE BUILDER, GETTER, SETTER (CONSTRUCTOR...)
public class RoleEntity extends BaseEntity {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ERole roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserEntity> users;

    public ERole getRoleName() {
        return this.roleName;
    }

    public void setRole(ERole role) {
        this.roleName = role;
    }

}
