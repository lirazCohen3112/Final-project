package com.example.finalproject.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;
import com.google.android.material.button.MaterialButton;

public class MenuClientActivity extends AppCompatActivity {

    private MaterialButton main_LBL_queue_reservation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_activity_menu);

        findViews();

        main_LBL_queue_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQueueClientActivity ();
            }
        });
    }

    private void findViews() {
        main_LBL_queue_reservation = findViewById(R.id.main_LBL_queue_reservation);
    }

    private void openQueueClientActivity (){
        Intent intent = new Intent(MenuClientActivity.this,  datesActivityClient.class);
        startActivity(intent);
        finish();
    }

}
