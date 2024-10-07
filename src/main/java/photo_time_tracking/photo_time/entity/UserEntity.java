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
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "description", nullable = true, unique = false)
    private String description;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id") // Khóa ngoại tham chiếu tới bảng role
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

    // TODO: FIX (LAMBOK) AUTO CREATE CONTRUCTOR, GETTER, SETTER

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
