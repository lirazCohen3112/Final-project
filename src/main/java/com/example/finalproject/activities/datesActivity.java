package com.example.finalproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.finalproject.R;
import com.google.android.material.button.MaterialButton;

public class datesActivity extends AppCompatActivity {

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

    }
    private void findViews(){

        dates_LBL_Sunday = findViewById(R.id.dates_LBL_Sunday);
        dates_LBL_Monday = findViewById(R.id.dates_LBL_Monday);
        dates_LBL_Tuesday = findViewById(R.id.dates_LBL_Tuesday);
        dates_LBL_Wednesday = findViewById(R.id.dates_LBL_Wednesday);
        dates_LBL_Thursday = findViewById(R.id.dates_LBL_Thursday);
        dates_LBL_Friday = findViewById(R.id.dates_LBL_Friday);
    }

    private void openListSunday (){
        Intent intent = new Intent(datesActivity.this, QueueTrackingActivity.class);
        startActivity(intent);
        finish();
    }
}