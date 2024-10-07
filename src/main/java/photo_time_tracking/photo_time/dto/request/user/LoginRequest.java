package photo_time_tracking.photo_time.dto.request.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class LoginRequest {

    private String userName;

    private String password;

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
