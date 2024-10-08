package photo_time_tracking.photo_time.dto.response.error;

import photo_time_tracking.photo_time.dto.response.BaseResponse;

// TODO: FIX ERROR LOMBOK AUTO CREATE CONTRUCTOR
public class ErrorResponse extends BaseResponse {

    public ErrorResponse(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public ErrorResponse(String code, Integer status, String message) {
        super(code, status, message);
    }
}
