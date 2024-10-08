package photo_time_tracking.photo_time.dto.response.user;

import photo_time_tracking.photo_time.dto.response.BaseResponse;

// TODO: FIX ERROR LOMBOK AUTO CREATE CONTRUCTOR
public class UserResponse extends BaseResponse {

    public UserResponse(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public UserResponse(String code, Integer status, String message) {
        super(code, status, message);
    }
}
