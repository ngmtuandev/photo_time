package photo_time_tracking.photo_time.utils;

import java.util.ResourceBundle;

public class BaseAmenityUtil {
    public String getMessageBundle(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("photo_time");
        return resourceBundle.getString(key);
    }
}
