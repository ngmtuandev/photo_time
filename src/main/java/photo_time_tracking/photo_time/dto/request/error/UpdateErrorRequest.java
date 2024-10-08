package photo_time_tracking.photo_time.dto.request.error;

import lombok.Data;

import java.util.UUID;

@Data
// TODO: FIX ERROR LOMBOK NOT USE AUTO CONSTRUCTOR
public class UpdateErrorRequest {

    private UUID id;

    private String errorCode;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public UUID getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
