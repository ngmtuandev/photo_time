package photo_time_tracking.photo_time.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import photo_time_tracking.photo_time.enums.ERole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private ERole roleCode;
}
