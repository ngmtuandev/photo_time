package photo_time_tracking.photo_time.dto.response.role;

import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.Getter;

import photo_time_tracking.photo_time.dto.response.BaseResponse;

@Getter
@Setter
@SuperBuilder
// TODO: FIX LOMBOK NOT CAN CREATE BUILDER (CONSTRUCTOR...)
public class RoleResponse extends BaseResponse {

    public RoleResponse(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public RoleResponse(String code, Integer status, String message) {
        super(code, status, message);
    }
}
