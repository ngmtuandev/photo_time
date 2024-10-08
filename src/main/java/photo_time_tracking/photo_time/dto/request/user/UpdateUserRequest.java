package photo_time_tracking.photo_time.dto.request.user;

import java.util.UUID;

public class UpdateUserRequest {

    private UUID id;

    private String userName;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }
}
