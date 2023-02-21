package com.example.finalproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.finalproject.R;
import com.example.finalproject.care.CareList;
import com.example.finalproject.fragments.FragmentslistCare;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class NewCareActivity extends AppCompatActivity {

    private FrameLayout table_records_LAY_list;
    private MaterialButton care_LBL_add_new_queue;
    private EditText care_EDT_name;
    private EditText care_EDT_explanation;
    private EditText care_EDT_cost;
    private EditText care_EDT_time;
    private FragmentslistCare fragments_list;
    private MaterialButton care_LBL_Return_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_care);

        findViews();

        fragments_list = new FragmentslistCare();
        getSupportFragmentManager().beginTransaction().add(R.id.table_records_LAY_list , fragments_list).commit();

        care_LBL_Return_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });


        care_LBL_add_new_queue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("cares");
                CareList.addCare(care_EDT_name.getText().toString() , care_EDT_explanation.getText().toString() ,
                        care_EDT_cost.getText().toString() ,
                        care_EDT_time.getText().toString());
                myRef.setValue(CareList.getCareList());
            }
        });
        fragments_list.readCare();
    }

    private void findViews() {
        table_records_LAY_list = findViewById(R.id.table_records_LAY_list);
        care_LBL_add_new_queue = findViewById(R.id.care_LBL_add_new_queue);

        care_EDT_name = findViewById(R.id.care_EDT_name);
        care_EDT_explanation = findViewById(R.id.care_EDT_explanation);
        care_EDT_cost = findViewById(R.id.care_EDT_cost);
        care_EDT_time = findViewById(R.id.care_EDT_time);

        care_LBL_Return_menu = findViewById(R.id.care_LBL_Return_menu);
    }

    private void openMenu(){
        Intent intent = new Intent(NewCareActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}