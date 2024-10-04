package photo_time_tracking.photo_time.dto.response.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
@Builder
public class UserProfileDTO {

    private UUID id;

    private String userName;

    private String email;
}
