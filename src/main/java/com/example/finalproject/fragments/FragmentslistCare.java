package com.example.finalproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Queue.Queue;
import com.example.finalproject.Queue.QueueList;
import com.example.finalproject.R;
import com.example.finalproject.care.Care;
import com.example.finalproject.care.CareAdapter;
import com.example.finalproject.care.CareList;
import com.example.finalproject.client.c.QueueClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentslistCare extends Fragment {

    private RecyclerView main_LST_list_care;
    private ArrayList<Care> cares;
    private CareAdapter careAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_care, container, false);

        main_LST_list_care = view.findViewById(R.id.main_LST_list_care);


        //CareList.addCare("lak", "wert", "30.5", "20");

        Show();
        // addCare();
       // readCare();

        return view;
    }

    public void Show() {
        cares = CareList.getCareList();
        careAdapter = new CareAdapter(this, cares);
        main_LST_list_care.setLayoutManager(new LinearLayoutManager(getContext()));
        main_LST_list_care.setAdapter(careAdapter);
    }

    private void addCare() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cares");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // cares.clear();
                for (DataSnapshot careSnapshot : snapshot.getChildren()) {
                    Care Q = careSnapshot.getValue(Care.class);
                    cares.add(Q);
                }
                careAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void readCare() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cares");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //cares.clear();
                for (DataSnapshot caresSnapshot : snapshot.getChildren()) {
                    //Care Q = caresSnapshot.getValue(Care.class);
                //    cares.add(Q);
                }
                careAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}