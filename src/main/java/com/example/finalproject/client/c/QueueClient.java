package com.example.finalproject.client.c;

public class QueueClient {

    private String Time;
    private String Status;

    public QueueClient(String status , String time){
        this.Time = time;
        this.Status = status;
    }

    public void setTime(String time){
        this.Time = time;
    }

    public String getTime(){
        return Time;
    }

    public void setStatus(String status){
        this.Status = status;
    }

    public String getStatus(){
        return Status;
    }

}
