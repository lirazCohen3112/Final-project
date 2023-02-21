package com.example.finalproject.Queue;

import com.example.finalproject.Queue.Queue;

import java.util.ArrayList;

public class QueueList {

    public static ArrayList<Queue> queues = new ArrayList<>();;

    public static void addQueue ( String status , String time  ){
        queues.add(new Queue(status, time));
    }

    public static ArrayList<Queue> getQueueLines (){
        return queues;
    }
}
