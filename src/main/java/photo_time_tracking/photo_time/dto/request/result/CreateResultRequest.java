package photo_time_tracking.photo_time.dto.request.result;
import lombok.Data;

@Data
public class CreateResultRequest {

    private String typeResult;

    public void setTypeResult(String typeResult) {
        this.typeResult = typeResult;
    }

    public String getTypeResult() {
        return typeResult;
    }
}
