package photo_time_tracking.photo_time.dto.request.user;
import lombok.Data;
import photo_time_tracking.photo_time.enums.ERole;

import java.util.UUID;


@Data
public class RegisterRequest {

    private String userName;

    private String password;

    private String description;

    private Boolean status;

    private UUID role;

    private UUID store;

    public UUID getRole() {
        return role;
    }

    public UUID getStore() {
        return store;
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
