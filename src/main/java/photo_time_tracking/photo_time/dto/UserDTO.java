package photo_time_tracking.photo_time.dto;

import java.util.UUID;

public class UserDTO {

    private UUID idUser;

    private String userName;

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }

    public UserDTO(String userName, String description, UUID idUser) {
        this.description = description;
        this.userName = userName;
        this.idUser = idUser;
    }
}
