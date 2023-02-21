package com.example.finalproject.client.c;

import java.util.ArrayList;

public class QueueClientList {
    public static ArrayList<QueueClient> queuesClient = new ArrayList<>();;

    public static void addQueueClient (String status , String time){
        queuesClient.add(new QueueClient(status , time ));
    }

    public static ArrayList<QueueClient> getQueuesClientLines (){
        return queuesClient;
    }
}
