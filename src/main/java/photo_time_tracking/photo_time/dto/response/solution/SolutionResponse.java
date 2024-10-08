package photo_time_tracking.photo_time.dto.response.solution;
import photo_time_tracking.photo_time.dto.response.BaseResponse;

public class SolutionResponse extends BaseResponse {

    public SolutionResponse(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public SolutionResponse(String code, Integer status, String message) {
        super(code, status, message);
    }
}
