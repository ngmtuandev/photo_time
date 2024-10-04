package photo_time_tracking.photo_time.dto.request.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import photo_time_tracking.photo_time.enums.ERole;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    private ERole role;
}
