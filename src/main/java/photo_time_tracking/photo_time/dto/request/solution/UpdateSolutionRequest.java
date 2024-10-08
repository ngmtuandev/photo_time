package photo_time_tracking.photo_time.dto.request.solution;

import java.util.UUID;

public class UpdateSolutionRequest {

    private UUID id;

    private String name;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
