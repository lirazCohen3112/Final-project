package com.example.finalproject.client.c;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Queue;

public class FragmentsClientlistQueue extends Fragment {

    private RecyclerView main_LST_list;
    private ArrayList<QueueClient> queuesClient;
    private QueueClientAdapter queueClientAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.client_fragment_list_queue, container, false);

       // QueueClientList.addQueueClient("available" , "15:00");

       // addQ();

        addQueues();
        QueueClientList.addQueueClient("f" , "17:00");

        main_LST_list = view.findViewById(R.id.main_LST_list);

        queuesClient = QueueClientList.getQueuesClientLines();
        queueClientAdapter = new QueueClientAdapter(this , queuesClient);
        main_LST_list.setAdapter(queueClientAdapter);


      //  queueClientAdapter.notifyDataSetChanged();
      //  main_LST_list.setAdapter(queueClientAdapter);

        main_LST_list.setLayoutManager(new LinearLayoutManager(getContext()));
        main_LST_list.setAdapter(queueClientAdapter);


        return view;
    }

    private void addQueues() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("qeueus");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                queuesClient.clear();
                for(DataSnapshot qeueusSnapshot: snapshot.getChildren()){
                    QueueClient Q = qeueusSnapshot.getValue(QueueClient.class);
                    queuesClient.add(Q);
                }
                queueClientAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addQ() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Qe");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //   Queue Qe = snapshot.getValue(Queue.class);
                String s = snapshot.child("status").getValue().toString();
                QueueClientList.addQueueClient(s , "13");
                // QueueClient q = snapshot.getValue(QueueClient.class);
                //  QueueClientList.addQueueClient(q.getStatus() + "", "13:00");
                queueClientAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
