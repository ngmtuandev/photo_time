package photo_time_tracking.photo_time.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@SuperBuilder
// TODO: FIX LOMBOK NOT CAN CREATE BUILDER (CONTRUCTOR...)
public abstract class BaseResponse {

    private String code;

    private Integer status;

    private String message;

    private long responseTime;

    private Object data;

    public BaseResponse(String code, Integer status, String message, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String code, Integer status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
