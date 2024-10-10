package photo_time_tracking.photo_time.dto.response.machine;

import photo_time_tracking.photo_time.dto.response.BaseResponse;

public class MachineResponse extends BaseResponse {

    public MachineResponse(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public MachineResponse(String code, Integer status, String message) {
        super(code, status, message);
    }
}
