package photo_time_tracking.photo_time.dto;

public class PaginationDTO {

    private Integer page;

    private Integer size;

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
