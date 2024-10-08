package photo_time_tracking.photo_time.dto.response.store;
import photo_time_tracking.photo_time.dto.response.BaseResponse;

// TODO: FIX ERROR LOMBOK AUTO CREATE CONTRUCTOR
public class StoreResponse extends BaseResponse {

    public StoreResponse(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public StoreResponse(String code, Integer status, String message) {
        super(code, status, message);
    }
}
