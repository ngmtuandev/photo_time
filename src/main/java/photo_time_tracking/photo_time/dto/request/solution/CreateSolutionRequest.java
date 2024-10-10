package photo_time_tracking.photo_time.dto.request.solution;
import lombok.Data;

@Data
// TODO: FIX ERROR LOMBOK NOT USE AUTO CONSTRUCTOR
public class CreateSolutionRequest {

    private String name;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
