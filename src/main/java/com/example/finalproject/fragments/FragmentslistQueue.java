package com.example.finalproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Queue.Queue;
import com.example.finalproject.Queue.QueueAdapter;
import com.example.finalproject.Queue.QueueList;
import com.example.finalproject.R;
import com.example.finalproject.client.c.QueueClientList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FragmentslistQueue extends Fragment {

    private RecyclerView main_LST_list;
    private ArrayList<Queue> queues;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_queue, container, false);

        main_LST_list = view.findViewById(R.id.main_LST_list);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("qeueus");
        Queue Q = new Queue("jk" , "13:00");
        QueueList.addQueue( "jk" , "13:00");
       // myRef.setValue(Q);

        Queue Q1 = new Queue("Djk" , "14:00");
        QueueList.addQueue("Djk" , "14:00");
        myRef.setValue( QueueList.getQueueLines());


        //  FirebaseDatabase database = FirebaseDatabase.getInstance();
       //   DatabaseReference myRef = database.getReference("Qe");

       //   Queue q1 = new Queue( "12:00", "available" );
       //   QueueList.addQueue(  "available" , "12:00");
      //    myRef.setValue(q1);

        queues = QueueList.getQueueLines();

        QueueAdapter queueAdapter = new QueueAdapter(this , queues);
        main_LST_list.setLayoutManager(new LinearLayoutManager(getContext()));
        main_LST_list.setAdapter(queueAdapter);

        return view;
    }
}
