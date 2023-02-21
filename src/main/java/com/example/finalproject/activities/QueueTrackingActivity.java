package com.example.finalproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.finalproject.R;
import com.example.finalproject.fragments.FragmentslistQueue;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class QueueTrackingActivity extends AppCompatActivity {

    private MaterialTextView table_records_LBL_title;
    private FrameLayout table_records_LAY_list;
    private MaterialButton care_LBL_Return_page;
    private MaterialButton care_LBL_Return_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_queue);

        findViews();

        care_LBL_Return_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDays();
            }
        });

        care_LBL_Return_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });



        //View view = inflater.inflate(R.layout.QueueTrackingActivity, container, false);

        FragmentslistQueue fragments_list = new FragmentslistQueue();
        getSupportFragmentManager().beginTransaction().add(R.id.table_records_LAY_list , fragments_list).commit();

    }

    private void findViews() {
        table_records_LAY_list = findViewById(R.id.table_records_LAY_list);
        table_records_LBL_title = findViewById(R.id.table_records_LBL_title);
        care_LBL_Return_page = findViewById(R.id.care_LBL_Return_page);
        care_LBL_Return_menu = findViewById(R.id.care_LBL_Return_menu);
    }

    private void openMenu(){
        Intent intent = new Intent(QueueTrackingActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void openDays(){
        Intent intent = new Intent(QueueTrackingActivity.this, datesActivity.class);
        startActivity(intent);
        finish();
    }
}