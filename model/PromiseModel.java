package model;


import java.time.LocalDate;

public class PromiseModel {
    private String promiseId;
    private String politicianId;
    private String desc;
    private LocalDate date;
    private Status status;

     public PromiseModel(String promiseId,String politicianId, String desc,  LocalDate date, Status status) {
        this.promiseId = promiseId;
        this.politicianId = politicianId;
        this.desc = desc;
        this.date = date;
        this.status = status;
    }

     public String getPromiseId() {
         return promiseId;
     }

     public void setPromiseId(String promiseId) {
         this.promiseId = promiseId;
     }

     public String getPoliticianId() {
         return politicianId;
     }

     public void setPoliticianId(String politicianId) {
         this.politicianId = politicianId;
     }

     public String getDesc() {
         return desc;
     }

     public void setDesc(String desc) {
         this.desc = desc;
     }

     public LocalDate getDate() {
         return date;
     }

     public void setDate(LocalDate date) {
         this.date = date;
     }

     public Status getStatus() {
         return status;
     }

     public void setStatus(Status status) {
         this.status = status;
     }

     public boolean canUpdate(){
        return this.status != Status.ABANDONED;
     }


   
    

    
}
