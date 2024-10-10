package photo_time_tracking.photo_time.dto.response.result;

import photo_time_tracking.photo_time.dto.response.BaseResponse;

public class ResultResponse extends BaseResponse {

    public ResultResponse(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public ResultResponse(String code, Integer status, String message) {
        super(code, status, message);
    }
}
