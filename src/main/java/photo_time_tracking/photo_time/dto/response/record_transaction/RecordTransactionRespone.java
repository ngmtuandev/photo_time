package photo_time_tracking.photo_time.dto.response.record_transaction;

import photo_time_tracking.photo_time.dto.response.BaseResponse;

public class RecordTransactionRespone extends BaseResponse {

    private Integer page;

    private Integer totalPage;

    public RecordTransactionRespone(String code, Integer status, String message, Object data) {
        super(code, status, message, data);
    }

    public RecordTransactionRespone(String code, Integer status, String message, Object data, Integer page, Integer totalPage) {
        super(code, status, message, data);
        this.page = page;
        this.totalPage = totalPage;
    }

    public RecordTransactionRespone(String code, Integer status, String message) {
        super(code, status, message);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
