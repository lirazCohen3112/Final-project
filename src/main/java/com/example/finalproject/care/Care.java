package com.example.finalproject.care;

public class Care {

    private String name;
    private String explanation;
    private String cost;
    private String time;

    public Care(String name , String explanation , String cost ,String time){
        this.name = name;
        this.explanation = explanation;
        this.cost = cost;
        this.time = time;
    }

    public String getName(){
        return name;
    }

    public String getExplanation(){
        return explanation;
    }

    public String getCost(){
        return cost;
    }

    public String getTime(){
        return time;
    }

}
