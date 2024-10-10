package photo_time_tracking.photo_time.dto.response.user;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class UserProfileDTO {

    private String id;

    private String userName;

    private String email;
}
