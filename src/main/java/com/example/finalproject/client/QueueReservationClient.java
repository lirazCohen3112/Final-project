package com.example.finalproject.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;
import com.example.finalproject.client.c.FragmentsClientlistQueue;
import com.example.finalproject.client.c.QueueClientList;
import com.google.android.material.button.MaterialButton;

public class QueueReservationClient extends AppCompatActivity {

    private EditText care_EDT_name;
    private EditText care_EDT_explanation;
    private MaterialButton care_LBL_add_new_queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queue_reservation);

        findViews();

        care_LBL_add_new_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                v.getContext().startActivity(new Intent(v.getContext(), FragmentsClientlistQueue.class));
            }
        });

    }
    private void findViews(){

        care_EDT_name = findViewById(R.id.care_EDT_name);
        care_EDT_explanation = findViewById(R.id.care_EDT_explanation);
        care_LBL_add_new_queue = findViewById(R.id.care_LBL_add_new_queue);

    }
}
