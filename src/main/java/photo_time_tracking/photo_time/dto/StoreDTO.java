package photo_time_tracking.photo_time.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StoreDTO {

    private UUID storeId;

    private String storeName;

    private String storeCode;

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public StoreDTO(String storeName, String storeCode, UUID storeId) {
        this.storeName = storeName;
        this.storeCode = storeCode;
        this.storeId = storeId;
    }
}
