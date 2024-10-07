package photo_time_tracking.photo_time.dto.request.role;

import lombok.*;
import jakarta.validation.constraints.NotNull;
import photo_time_tracking.photo_time.constant.Message;
import photo_time_tracking.photo_time.enums.ERole;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleRequest {

    @NotNull(message = Message.ROLE_NOT_NULL)
    private ERole role;

    public ERole getRole() {
        return this.role;
    }
}
