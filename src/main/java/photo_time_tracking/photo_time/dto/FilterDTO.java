package photo_time_tracking.photo_time.dto;

import java.util.UUID;

public class FilterDTO {

    private Integer page;

    private Integer size;

    private UUID storeId;

    private UUID userId;

    private UUID errorId;

    public Integer getPage() {
        return page;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public void setStoreId(UUID storeId) {
        this.storeId = storeId;
    }

    public UUID getStoreId() {
        return storeId;
    }

    public UUID getUserId() {
        return userId;
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

    public void setErrorId(UUID errorId) {
        this.errorId = errorId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
