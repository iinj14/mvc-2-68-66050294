package model;

import java.time.LocalDate;

public class PromiseUpdate {
    private String promiseId;
    private LocalDate updateDate;
    private String updateDetail;

    public PromiseUpdate(String promiseId, LocalDate updateDate, String updateDetail) {
        this.promiseId = promiseId;
        this.updateDate = updateDate;
        this.updateDetail = updateDetail;
    }

    public String getPromiseId() {
        return promiseId;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public String getUpdateDetail() {
        return updateDetail;
    }

    

    
}
