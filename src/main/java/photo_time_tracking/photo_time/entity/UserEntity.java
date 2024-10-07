package photo_time_tracking.photo_time.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Data
@Entity
public class UserEntity extends BaseEntity {
    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "description", nullable = true, unique = false)
    private String description;

    @Column(name = "status")
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private RoleEntity role;

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

    public Boolean getStatus() {
        return this.status;
    }


}
