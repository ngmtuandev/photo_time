package photo_time_tracking.photo_time.dto;

public class SolutionDTO {

    private String name;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public SolutionDTO(String name, String description) {
        this.description = description;
        this.name = name;
    }
}
