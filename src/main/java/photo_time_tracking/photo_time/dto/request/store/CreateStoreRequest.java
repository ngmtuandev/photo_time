package photo_time_tracking.photo_time.dto.request.store;

import lombok.Data;

@Data
// TODO: FIX ERROR LOMBOK NOT USE AUTO CONSTRUCTOR
public class CreateStoreRequest {

    private String storeName;

    private String storeCode;

    // getter
    public String getStoreName() {
        return storeName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    // setter
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
