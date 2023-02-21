package com.example.finalproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.finalproject.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuActivity extends AppCompatActivity {

    private MaterialButton main_LBL_queue_tracking;
    private MaterialButton main_LBL_new_queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

        findViews();

         // כפתור של הרשימה של התורים
        main_LBL_queue_tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dayas();
            }
        });


        main_LBL_new_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { addNewQueue();
            }
        });
    }

    private void findViews() {
        main_LBL_queue_tracking = findViewById(R.id.main_LBL_queue_tracking);
        main_LBL_new_queue = findViewById(R.id.main_LBL_new_queue);
    }

    //לוחצים על הכפתור ונפתח רשימת התורים
    private void openQueueTrackingActivity (){
        Intent intent = new Intent(MenuActivity.this, QueueTrackingActivity.class);
        startActivity(intent);
        finish();
    }

    private void addNewQueue (){
        Intent intent = new Intent(MenuActivity.this, NewCareActivity.class);
        startActivity(intent);
        finish();
    }

    private void dayas (){
        Intent intent = new Intent(MenuActivity.this, datesActivity.class);
        startActivity(intent);
        finish();
    }
}