package photo_time_tracking.photo_time.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

    private UUID idResult;

    private String typeResult;

    public String getTypeResult() {
        return typeResult;
    }

    public UUID getIdResult() {
        return idResult;
    }

    public void setTypeResult(String typeResult) {
        this.typeResult = typeResult;
    }

    public void setIdResult(UUID idResult) {
        this.idResult = idResult;
    }

    public ResultDTO(String typeResult, UUID idResult) {
        this.typeResult = typeResult;
        this.idResult = idResult;
    }
}
