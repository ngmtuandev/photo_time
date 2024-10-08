package photo_time_tracking.photo_time.dto.request.error;

import lombok.Data;

@Data
// TODO: FIX ERROR LOMBOK NOT USE AUTO CONSTRUCTOR
public class CreateErrorRequest {

    private String errorCode;

    private String description;

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
