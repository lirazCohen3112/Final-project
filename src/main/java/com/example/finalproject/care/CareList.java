package com.example.finalproject.care;

import com.example.finalproject.care.Care;

import java.util.ArrayList;

public class CareList {

    public static ArrayList<Care> cares = new ArrayList<>();;

    public static void addCare (String name , String explanation , String cost ,String time){
        cares.add(new Care(name , explanation , cost , time));
    }

    public static ArrayList<Care> getCareList (){
        return cares;
    }

    public static void add(Care c) {
        cares.add(new Care(c.getName() , c.getExplanation() , c.getCost() , c.getTime()));
    }
}
