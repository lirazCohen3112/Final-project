package com.example.finalproject.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;
import com.example.finalproject.client.c.QueueClientActivity;
import com.google.android.material.button.MaterialButton;

public class datesActivityClient extends AppCompatActivity {

    private ImageButton dates_LBL_Sunday;
    private ImageButton dates_LBL_Monday;
    private ImageButton dates_LBL_Tuesday;
    private ImageButton dates_LBL_Wednesday;
    private ImageButton dates_LBL_Thursday;
    private ImageButton dates_LBL_Friday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dates);

        findViews();

        dates_LBL_Sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openListSunday ();
            }
        });

        dates_LBL_Monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openListMonday ();
            }
        });

        dates_LBL_Tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openListTuesday ();
            }
        });

        dates_LBL_Wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openListWednesday ();
            }
        });

        dates_LBL_Thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openListThursday();
            }
        });

        dates_LBL_Friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openListFriday ();
            }
        });

    }
    private void findViews(){

        dates_LBL_Sunday = findViewById(R.id.dates_LBL_Sunday);
        dates_LBL_Monday = findViewById(R.id.dates_LBL_Monday);
        dates_LBL_Tuesday = findViewById(R.id.dates_LBL_Tuesday);
        dates_LBL_Wednesday = findViewById(R.id.dates_LBL_Wednesday);
        dates_LBL_Thursday = findViewById(R.id.dates_LBL_Thursday);
        dates_LBL_Sunday = findViewById(R.id.dates_LBL_Sunday);
        dates_LBL_Friday = findViewById(R.id.dates_LBL_Friday);
    }

    private void openListSunday (){
        Intent intent = new Intent(datesActivityClient.this, QueueClientActivity.class);
        startActivity(intent);
        finish();
    }

    private void openListMonday (){
        Intent intent = new Intent(datesActivityClient.this, QueueClientActivity.class);
        startActivity(intent);
        finish();
    }

    private void openListTuesday (){
        Intent intent = new Intent(datesActivityClient.this, QueueClientActivity.class);
        startActivity(intent);
        finish();
    }

    private void openListWednesday (){
        Intent intent = new Intent(datesActivityClient.this, QueueClientActivity.class);
        startActivity(intent);
        finish();
    }

    private void openListThursday (){
        Intent intent = new Intent(datesActivityClient.this, QueueClientActivity.class);
        startActivity(intent);
        finish();
    }

    private void openListFriday (){
        Intent intent = new Intent(datesActivityClient.this, QueueClientActivity.class);
        startActivity(intent);
        finish();
    }
}
