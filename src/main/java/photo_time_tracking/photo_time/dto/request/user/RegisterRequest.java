package photo_time_tracking.photo_time.dto.request.user;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterRequest {

    private String userName;

    private String password;

    private String description;

    private Boolean status;

    private UUID role;

    public UUID getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
